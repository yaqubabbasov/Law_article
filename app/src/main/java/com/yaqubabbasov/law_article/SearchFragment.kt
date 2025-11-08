package com.yaqubabbasov.law_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaqubabbasov.law_article.databinding.FragmentSearchBinding
import java.util.Locale


class SearchFragment : Fragment() {
private var _binding:FragmentSearchBinding?=null
    private val binding:FragmentSearchBinding get() = _binding!!
    val list = ArrayList<DataSearch>()
    val adapter=SearchAdapter(list)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleview()
        search()


    }
    private fun recycleview(){
        binding.rvsearch.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
         binding.rvsearch.adapter= adapter

    }
    private fun search(){

        val d1 = DataSearch(R.drawable.putin,"Rusiyaya bağlı 4 hərbi qulluqçu Rusiyanın Ukraynaya müdaxiləsi ilə əlaqədar müharibə cinayətlərdə ittiham olunur")
        val d2 =DataSearch(R.drawable.animaamerica,"ABŞ Rusiya-Ukrayna müharibəsi ilə bağlı ilk müharibə cinayətləri ittihamını irəli sürüb")
        val d3=DataSearch(R.drawable.americaukra,"ABŞ Ukrayna işğalında amerikalıya işgəncə verməkdə ittiham olunan ruslara qarşı müharibə cinayəti ittihamı irəli sürüb")
        val d4= DataSearch(R.drawable.russianwar3,"Müharibə cinayəti nədir və Putin Ukraynaya görə mühakimə oluna bilərmi?")
        val d5= DataSearch(R.drawable.russianwar1,"BMT Komissiyası Ukraynada  dinc əhalinin əziyyət çəkməsindən narahatlığını ifadə edib")
        val d6 = DataSearch(R.drawable.russianwar2,"BMT Rusiyanın Ukraynadakı müharibə cinayətlərinə dair əlavə sübutlar tapıb")
        list.add(d1)
        list.add(d2)
        list.add(d3)
        list.add(d4)
        list.add(d5)
        list.add(d6)


        binding.searchview.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newtext: String?): Boolean {
             filterList(newtext)
                return true
            }

        })
    }
    private fun filterList(query:String?){
        if (query!=null){
            val filteredlist = ArrayList<DataSearch>()
            for (i in list){
                if (i.searchtitle.lowercase(Locale.ROOT).contains(query)){
                    filteredlist.add(i)
                }

            }
            if (filteredlist.isEmpty()){
                Toast.makeText(requireContext(),"No Data Found",Toast.LENGTH_SHORT).show()
            }else{
                adapter.updatelist(list)
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}