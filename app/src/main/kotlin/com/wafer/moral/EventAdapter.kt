package com.wafer.moral

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * The EventAdapter class
 * Please put more info here.
 * @author wafer
 * @since 17/4/15 18:03
 */

class EventAdapter(private val data: Array<out String>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val textView = holder?.textView?.findViewById(R.id.event) as TextView
        textView.text = data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_event, parent, false))
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)
}

