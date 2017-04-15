package com.wafer.moral

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.wafer.moral.model.response.ActivitiesResponse
import kotlinx.android.synthetic.main.activity_moral_looking.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoralLookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moral_looking)

        val studentId = intent.getStringExtra(Constants.STUDENT_ID)

        student_id.text = getString(R.string.student_id_is).format(studentId)

        ApiManager.service.getActivities(studentId).enqueue(object : Callback<ActivitiesResponse> {
            override fun onFailure(call: Call<ActivitiesResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ActivitiesResponse>?, response: Response<ActivitiesResponse>?) {

                if (response != null && response.isSuccessful) {
                    val activitiesResponse = response.body()
                    val totalGrade = activitiesResponse.totalGrade
                    val data = activitiesResponse.activityList

                    events.setHasFixedSize(true)
                    events.layoutManager = LinearLayoutManager(this@MoralLookingActivity)
                    events.adapter = EventAdapter(data, this@MoralLookingActivity)
                    events.addItemDecoration(DividerItemDecoration(this@MoralLookingActivity, DividerItemDecoration.VERTICAL))

                    total_point.text = getString(R.string.moral_is).format(totalGrade)
                }
            }
        })
    }
}
