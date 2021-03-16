package com.example.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(val context: Context, val carClick: (Car) -> Unit) : ListAdapter<Car, CarAdapter.ViewHolder>(CarDiffCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val manufacturerText = view.findViewById(R.id.manufacturerText) as TextView
        val modelText = view.findViewById(R.id.modelText) as TextView
        val priceText = view.findViewById(R.id.priceText) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.manufacturerText.text = data.manufacturer
        holder.modelText.text = data.model
        holder.priceText.text = context.getString(R.string.price, data.price)
        holder.itemView.setOnClickListener{
            carClick(data)
        }
    }
}

class CarDiffCallback : DiffUtil.ItemCallback<Car>() {
    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }
}
