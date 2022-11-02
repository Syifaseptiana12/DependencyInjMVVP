package com.syfsdi.dependencyinjmvvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syfsdi.dependencyinjmvvp.databinding.ItemMakeupBinding
import com.syfsdi.dependencyinjmvvp.model.ResponseDataMakeup
import com.syfsdi.dependencyinjmvvp.model.ResponseDataMakeupItem

class MakeupAdapter (var listmakeupr : List<ResponseDataMakeupItem>): RecyclerView.Adapter<MakeupAdapter.ViewHolder>() {
    var onDelete : ((ResponseDataMakeupItem)->Unit)? = null
    var onDetail : ((ResponseDataMakeup)->Unit)? = null

    class  ViewHolder(var binding: ItemMakeupBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeupAdapter. ViewHolder,@SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameMakeup.text = listmakeupr!![position].name
        holder.binding.categoryMakeup.text = listmakeupr!![position].category
        holder.binding.priceMakeup.text = listmakeupr!![position].price.toString()
        Glide.with(holder.itemView.context).load(listmakeupr!![position].image).into(holder.binding.imgMakeup)

        holder.binding.deleteMakeup.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(v: View?) {
                val bun = Bundle()
                bun.putString("id", listmakeupr[position].id.toString())
            }
        })
    }

    override fun getItemCount(): Int {
        return listmakeupr.size
    }
}

