package com.latihan.myUAS.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.latihan.myuas.R
import com.latihan.myUAS.retrofit.PostResponseRS

class PostAdapterRS (
    val rumah_sakit : ArrayList<PostResponseRS.DataRS>
): RecyclerView.Adapter<PostAdapterRS.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_rs, parent ,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = rumah_sakit[position]
        holder.textNamaRS.text = data.nama_rs
        holder.textAlamatRS.text = data.alamat
    }

    override fun getItemCount()= rumah_sakit.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val textNamaRS = view.findViewById<TextView>(R.id.tvNamaRS)
        val textAlamatRS = view.findViewById<TextView>(R.id.tvAlamatRS)
    }

    public fun setData(data: List<PostResponseRS.DataRS>){
        rumah_sakit.clear()
        rumah_sakit.addAll(data)
        notifyDataSetChanged()
    }
}