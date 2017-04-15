package com.wafer.moral

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.wafer.moral.model.request.LoginRequest
import com.wafer.moral.model.response.LoginResponse
import kotlinx.android.synthetic.main.content_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            val id = student_id.editText?.text.toString()
            val password = student_password.editText?.text.toString()

            val isIdFormatCorrect = isIdFormatCorrect(id)
            val isPasswordFormatCorrect = isPasswordFormatCorrect(password)

            if (!isIdFormatCorrect)
                student_id.error = getString(R.string.student_id_or_teacher_id_must_10)

            if (!isPasswordFormatCorrect)
                student_password.error = getString(R.string.password_not_empty)

            if (isIdFormatCorrect && isPasswordFormatCorrect) {
                val call = ApiManager.service.login(LoginRequest(id, password))

                call.enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        Log.d("fail", "true")
                        Log.d("network Throwable", t.toString())
                    }

                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        if (response != null && response.isSuccessful) {
                            val loginRequest = response.body()

                            when (loginRequest.accountType) {
                                "T" -> {
                                    val intent = Intent(this@LoginActivity, LookStudentMoralActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }

                                "S" -> {
                                    val intent = Intent(this@LoginActivity, MoralLookingActivity::class.java)
                                    intent.putExtra(Constants.STUDENT_ID, id)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        } else {
                            student_id.error = getString(R.string.id_or_password_wrong)
                            student_password.error = getString(R.string.id_or_password_wrong)
                        }
                    }
                })
            }
        }

        student_id.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                student_id.error = null
                student_id.isErrorEnabled = false
            }
        })

        student_password.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                student_password.error = null
                student_password.isErrorEnabled = false
            }
        })
    }

    private fun isIdFormatCorrect(id: String?): Boolean = if (id == null) false else id.length == 10

    private fun isPasswordFormatCorrect(password: String?): Boolean = !password.isNullOrBlank()
}
