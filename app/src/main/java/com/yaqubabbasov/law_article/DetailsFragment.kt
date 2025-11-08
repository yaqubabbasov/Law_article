package com.yaqubabbasov.law_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yaqubabbasov.law_article.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
private var _binding: FragmentDetailsBinding?=null
    private val binding: FragmentDetailsBinding get() = _binding!!
    val args by navArgs<DetailsFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val info = args.Datainfo
        with(binding){
            infoimage.setImageResource(info.image)
            infotext.text=info.text
            infotitle.text=info.title
            arrowbutton.setOnClickListener {
                findNavController().popBackStack()
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}