package com.wafer.moral

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_moral_looking.*

class MoralLookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moral_looking)

        val studentId = intent.getStringExtra(Constants.STUDENT_ID)
        val student = TestData.userMoralData.find { it.id == studentId }

        if (student == null) {
            moralText.text = getString(R.string.no_student)
        }
        else {
            moralText.text = getString(R.string.moral_is).format(student.moral)
        }
    }
}
