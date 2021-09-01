package com.example.retrofitkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecAdapter(var context: Context, var list: List<DataModel>) :
    RecyclerView.Adapter<RecAdapter.RcViewHolder>() {


    class RcViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sampleImage: ImageView = itemView.findViewById(R.id.sampleImage)
        var sampleID: TextView = itemView.findViewById(R.id.sampleID)
        var sampleTitle: TextView = itemView.findViewById(R.id.sampleTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false)
        return RcViewHolder(view)
    }

    override fun onBindViewHolder(holder: RcViewHolder, position: Int) {
        var dataModel = list[position]
        Picasso.get().load(dataModel.url).placeholder(R.mipmap.ic_launcher).into(holder.sampleImage)
        holder.sampleID.text = dataModel.id
        holder.sampleTitle.text = dataModel.title
    }

    override fun getItemCount(): Int {
        return list.size
    }


}