package com.wafer.moral

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_look_student_moral.*

class LookStudentMoralActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_student_moral)

        look.setOnClickListener {
            val studentId = look_student_id.editText?.text.toString()

            if (studentId.isNullOrBlank())
                look_student_id.error = getString(R.string.student_id_not_null)
            else {
                val student = TestData.userMoralData.find { !it.isTeacher && it.id == studentId }

                if (student == null)
                    look_student_id.error = getString(R.string.no_student)
                else {
                    val intent = Intent(this, MoralLookingActivity::class.java)
                    intent.putExtra(Constants.STUDENT_ID, studentId)
                    startActivity(intent)
                }
            }
        }
    }
}
