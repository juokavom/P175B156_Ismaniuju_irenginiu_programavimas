package com.example.cpu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cpu.databinding.FragmentSecondBinding

class CpuAdapter(val carClick: (Cpu) -> Unit) :
    ListAdapter<Cpu, CpuAdapter.ViewHolder>(CpuDiffCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val manufacturerText = view.findViewById(R.id.manufacturerText) as TextView
        val modelText = view.findViewById(R.id.modelText) as TextView
        val priceText = view.findViewById(R.id.priceText) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cpu, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.manufacturerText.text = data.manufacturer
        holder.modelText.text = data.model
        holder.priceText.text = data.price.toString()
        holder.itemView.setOnClickListener {
            carClick(data)
        }
    }

    class CpuDiffCallback : DiffUtil.ItemCallback<Cpu>() {
        override fun areItemsTheSame(oldItem: Cpu, newItem: Cpu): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cpu, newItem: Cpu): Boolean {
            return oldItem == newItem
        }
    }
}