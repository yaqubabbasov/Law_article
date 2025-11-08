package com.yaqubabbasov.law_article

import android.provider.ContactsContract.RawContacts.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaqubabbasov.law_article.databinding.ItemBinding

class SearchAdapter(var searchlist:List<DataSearch>):RecyclerView.Adapter<SearchAdapter.Adapterviewholder>() {
    inner class Adapterviewholder(var binding:ItemBinding):RecyclerView.ViewHolder(binding.root)
    val searclist =ArrayList<DataSearch>()



    /*fun setfilteredlist (list: List<DataSearch>) {
        this.searchlist=list
        notifyDataSetChanged()


    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterviewholder{
        var layout = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Adapterviewholder(layout)
    }

    override fun getItemCount(): Int {
     return searchlist.size
    }

    override fun onBindViewHolder(holder: Adapterviewholder, position: Int) {
      val item = searchlist[position]
        holder.binding.image.setImageResource(item.searchmiage)
        holder.binding.title.text=item.searchtitle

    }
    fun updatelist (list: List<DataSearch>){
        searclist.clear()
        searclist.addAll(list)
        notifyDataSetChanged()
    }
}