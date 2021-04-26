package edu.ktu.doggyroomstarter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.ktu.doggyroomstarter.databinding.ItemDogBinding
import edu.ktu.doggyroomstarter.models.Dog

class DogAdapter : ListAdapter<Dog, DogAdapter.ViewHolder>(DogDiffCallback()) {

    class ViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: Dog) {
            binding.dog = dog
        }
    }

    class DogDiffCallback : DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDogBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}