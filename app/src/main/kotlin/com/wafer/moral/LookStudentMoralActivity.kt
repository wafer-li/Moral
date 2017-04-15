package com.wafer.moral

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wafer.moral.model.response.ActivitiesResponse
import kotlinx.android.synthetic.main.activity_look_student_moral.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LookStudentMoralActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_student_moral)

        look.setOnClickListener {
            val studentId = look_student_id.editText?.text.toString()

            if (studentId.isNullOrBlank())
                look_student_id.error = getString(R.string.student_id_not_null)
            else {
                ApiManager.service.getActivities(studentId).enqueue(object : Callback<ActivitiesResponse> {
                    override fun onFailure(call: Call<ActivitiesResponse>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<ActivitiesResponse>?, response: Response<ActivitiesResponse>?) {
                        if (response != null && response.isSuccessful) {
                            val intent = Intent(this@LookStudentMoralActivity, MoralLookingActivity::class.java)
                            intent.putExtra(Constants.STUDENT_ID, studentId)
                            startActivity(intent)
                        } else {
                            look_student_id.error = getString(R.string.no_student)
                        }
                    }
                })
            }
        }
    }
}
