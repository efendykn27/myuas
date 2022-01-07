package com.latihan.myUAS.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.latihan.myuas.model.PostResponse
import com.latihan.myuas.R

class PostAdapter (
    val puskesmas : ArrayList<PostResponse.Data>
): RecyclerView.Adapter<PostAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_pus, parent ,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = puskesmas[position]
        holder.textNamaPus.text = data.nama_pus
        holder.textAlamatPus.text = data.alamat
        holder.textJenusPus.text = data.jenis
    }

    override fun getItemCount()= puskesmas.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val textNamaPus = view.findViewById<TextView>(R.id.tvNamaPus)
        val textAlamatPus = view.findViewById<TextView>(R.id.tvAlamatPus)
        val textJenusPus = view.findViewById<TextView>(R.id.tvJenisPus)

    }

    public fun setData(data: List<PostResponse.Data>){
        puskesmas.clear()
        puskesmas.addAll(data)
        notifyDataSetChanged()
    }
}