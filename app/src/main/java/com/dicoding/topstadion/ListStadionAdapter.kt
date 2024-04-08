package com.dicoding.topstadion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.topstadion.databinding.ItemRowStadiBinding

class ListStadionAdapter(private val listStadion: ArrayList<Stadion>) : RecyclerView.Adapter<ListStadionAdapter.ListViewHolder>() {

   class ListViewHolder(var binding: ItemRowStadiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
      val binding = ItemRowStadiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listStadion.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (name,description,photo) = listStadion[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemName.text = description

    }

}