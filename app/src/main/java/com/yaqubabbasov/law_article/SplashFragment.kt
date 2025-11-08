package com.yaqubabbasov.law_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.yaqubabbasov.law_article.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {
private var _binding:FragmentSplashBinding?=null
    private val binding:FragmentSplashBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(4000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        }
        lottieanimation()

    }
    private fun lottieanimation(){
        with(binding){
            lawanimation.setMinProgress(0.0f)
            lawanimation.setMaxProgress(1.0f)
            lawanimation.repeatCount=3
            lawanimation.repeatMode=LottieDrawable.RESTART
            lawanimation.playAnimation()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}