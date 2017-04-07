package com.wafer.moral

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_login.*

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
                val userAuth = UserAuthentication(id, password)

                if (TestData.userAuthData.contains(userAuth)) {
                    //TODO Jump to Moral Looking
                }
                else {
                    student_id.error = getString(R.string.id_or_password_wrong)
                    student_password.error = getString(R.string.id_or_password_wrong)
                }
            }
        }

        student_id.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && student_id.isErrorEnabled) {
                student_id.error = null
                student_id.isErrorEnabled = false
            }
        }

        student_password.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && student_password.isErrorEnabled) {
                student_password.error = null
                student_password.isErrorEnabled = false
            }
        }
    }

    private fun isIdFormatCorrect(id: String?): Boolean = if (id == null) false else id.length == 10

    private fun isPasswordFormatCorrect(password: String?): Boolean = !password.isNullOrBlank()
}
