package com.yaqubabbasov.law_article

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.yaqubabbasov.law_article.databinding.FragmentLoginBinding
import com.yaqubabbasov.law_article.databinding.FragmentSplashBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class LoginFragment : Fragment() {
   private var _binding:FragmentLoginBinding?=null
    private val binding:FragmentLoginBinding get() = _binding!!
    private val auth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animations()
        signup()
        remember()
        binding.loginbutton.setOnClickListener {
            validation()
        }



    }
    private fun signup(){
        binding.signupbutton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }


    }


    private fun remember(){
        binding.checkbox.setOnClickListener {
            if (binding.checkbox.isChecked){
                binding.loginbutton.backgroundTintList= ColorStateList.valueOf(resources.getColor(R.color.blue))
                binding.loginbutton.setOnClickListener {
                    val email= binding.loginemail.text.toString().trim()
                    val password = binding.loginpassword.text.toString().trim()
                    if (email.isEmpty()||password.isEmpty()){
                        MotionToast.createColorToast(requireActivity(), "Warning",
                            "Fill the gaps",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))
                    }else{
                        login()
                    }

                }

            }else{
                binding.loginbutton.backgroundTintList=ColorStateList.valueOf(resources.getColor(R.color.softblue))
                binding.loginbutton.setOnClickListener {
                    validation()
                }


            }
        }

    }
    private fun validation(){
        with(binding){
            val email = loginemail.text.toString()
            val password = loginpassword.text.toString()
            if (email.trim().isEmpty()|| password.trim().isEmpty()){
                MotionToast.createColorToast(requireActivity(), "Warning",
                    "Fill the gaps",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))

            }else if (checkbox.isChecked==false){
                MotionToast.createColorToast(requireActivity(), "Warning",
                    "Checkbox is empty",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))

            }


        }

    }
    private fun login(){
        val email = binding.loginemail.text.toString()
        val password= binding.loginpassword.text.toString()
        auth.signInWithEmailAndPassword(email,password).
                addOnSuccessListener {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }.addOnFailureListener {
            MotionToast.createColorToast(requireActivity(), "Error",
                it.localizedMessage,
                MotionToastStyle.WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))

        }

    }


    private fun animations(){
        with(binding){
            helloanimation.setMinProgress(0.0f)
            helloanimation.setMaxProgress(1.0f)
            helloanimation.repeatCount=100
            helloanimation.repeatMode=LottieDrawable.RESTART
            helloanimation.playAnimation()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}