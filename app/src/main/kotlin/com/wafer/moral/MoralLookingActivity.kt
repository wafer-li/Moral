package com.wafer.moral

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_moral_looking.*

class MoralLookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moral_looking)

        val studentId = intent.getStringExtra(Constants.STUDENT_ID)

        events.setHasFixedSize(true)
        events.layoutManager = LinearLayoutManager(this)
        events.adapter = EventAdapter(resources.getStringArray(R.array.events))

        events.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
