package com.ramgdeveloper.elephantsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramgdeveloper.elephantsapi.databinding.ElephantsRowBinding

class ElephantsAdapter: ListAdapter<Elephants.ElephantsItem, ElephantsAdapter.MyViewHolder>(DiffUtilCallback) {

    object DiffUtilCallback: DiffUtil.ItemCallback<Elephants.ElephantsItem>() {
        override fun areItemsTheSame(oldItem: Elephants.ElephantsItem, newItem: Elephants.ElephantsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Elephants.ElephantsItem, newItem: Elephants.ElephantsItem): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class MyViewHolder(private val binding: ElephantsRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(elephants: Elephants.ElephantsItem?) {

            Glide.with(binding.image)
                .load(elephants?.image)
                .circleCrop()
                .into(binding.image)

            binding.textViewName.text = ("Name: "+ elephants?.name)
            binding.textViewSpecies.text = ("Species: "+ elephants?.species)
            binding.textViewStatus.text = ("Sex: "+ elephants?.sex)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ElephantsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val elephants = getItem(position)
        holder.bind(elephants)
    }
}

