package com.yaqubabbasov.law_article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yaqubabbasov.law_article.databinding.ItemBinding

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.Viewholder>() {
    inner class Viewholder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)
    val newslist = ArrayList<Newsdata>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var layout = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Viewholder(layout)
    }

    override fun getItemCount(): Int {
       return newslist.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = newslist[position]
        holder.binding.title.text=item.title
        holder.binding.image.setImageResource(item.image)
        holder.binding.cardinfo.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
        }
    }
    fun updatelist(list: List<Newsdata>){
        newslist.clear()
        newslist.addAll(list)
        notifyDataSetChanged()
    }
}