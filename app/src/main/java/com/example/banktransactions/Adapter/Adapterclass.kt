package com.example.banktransactions.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banktransactions.databinding.ContainerBinding
import com.example.banktransactions.dataclass.Transactons

class Adapterclass(private val arrposts: List<Transactons>) : RecyclerView.Adapter<Adapterclass.ViewHolder>(){

    inner class ViewHolder(private val binding: ContainerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transactons: Transactons) {
            binding.tvUserid.text = transactons.targetAccount.toString()
            binding.tvId.text = transactons.value.toString()
            binding.tvTitle.text = transactons.description
            binding.tvBody.text = transactons.id
            binding.tvDate.text = transactons.date.toString()




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrposts.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = arrposts[position]
        holder.bind(post)
    }
}