package com.yaqubabbasov.law_article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yaqubabbasov.law_article.databinding.ItemHorizontalBinding

class HorizontalNewsAdapter:RecyclerView.Adapter<HorizontalNewsAdapter.Viewholder>() {
    inner class Viewholder(var binding:ItemHorizontalBinding):RecyclerView.ViewHolder(binding.root)
    val list1 = ArrayList<Newsdata>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val layout = ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Viewholder(layout)
    }

    override fun getItemCount(): Int {
     return list1.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
      val item = list1[position]
        holder.binding.horizontalimage.setImageResource(item.image)
        holder.binding.horizontaltext.text= item.title
        holder.binding.cardhorizontal.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
        }
    }
    fun updatelist(list: List<Newsdata>){
        list1.clear()
        list1.addAll(list)
        notifyDataSetChanged()

    }
}