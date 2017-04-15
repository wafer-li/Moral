package com.wafer.moral.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wafer.moral.R
import com.wafer.moral.model.response.ActivityListItem

/**
 * The EventAdapter class
 * Please put more info here.
 * @author wafer
 * @since 17/4/15 18:03
 */

class EventAdapter(private val data: List<ActivityListItem?>?, private val context: Context) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val rootView = holder!!.view

        val eventNameView = rootView.findViewById(R.id.event_name) as TextView
        val eventTimeView = rootView.findViewById(R.id.event_time) as TextView
        val eventGradeView = rootView.findViewById(R.id.event_grade) as TextView


        eventNameView.text = data!![position]!!.activityName
        eventTimeView.text = data[position]!!.time
        eventGradeView.text = context.resources.getString(R.string.grade_is).format(data[position]!!.grade.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_event, parent, false))
    }

    override fun getItemCount(): Int = data?.size ?: 0

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}

