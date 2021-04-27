package com.sf10.actors
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sf10.actors.databinding.ItemActorBinding

class ActorAdapter(val clickListener: ActorClickListener) :
    ListAdapter<Actor, ActorAdapter.ViewHolder>(ActorDiffCallback()) {

    class ViewHolder(val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Actor, clickListener: ActorClickListener) {
            binding.actor = actor
            binding.clickListener = clickListener
        }
    }

    class ActorDiffCallback : DiffUtil.ItemCallback<Actor>() {
        override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem.actorId == newItem.actorId
        }

        override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem == newItem
        }
    }

    class ActorClickListener(val clickListener: (actor: Actor) -> Unit) {
        fun onClick(actor: Actor) {
            clickListener(actor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemActorBinding
                .inflate(
                    LayoutInflater
                        .from(parent.context)
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }


}