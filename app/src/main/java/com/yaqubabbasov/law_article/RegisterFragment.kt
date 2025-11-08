package com.yaqubabbasov.law_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.yaqubabbasov.law_article.databinding.FragmentRegisterBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding get() = _binding!!
    private val auth= FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerbutton.setOnClickListener {
            validation()
        }
        textbutton()




    }
    private fun textbutton(){
        binding.logintextbutton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun validation(){
        with(binding) {
            val email = registeremail.text.toString()
            val password = registerpassword.text.toString()
            if (email.trim().isEmpty() || password.trim().isEmpty()) {
                MotionToast.createColorToast(
                    requireActivity(), "Warning",
                    "Fill the gaps",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(
                        requireContext(),
                        www.sanju.motiontoast.R.font.helvetica_regular
                    )
                )
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        MotionToast.createColorToast(
                            requireActivity(), "Success",
                            "Created",
                            MotionToastStyle.SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(
                                requireContext(),
                                www.sanju.motiontoast.R.font.helvetica_regular
                            )
                        )

                    }.addOnFailureListener {
                        MotionToast.createColorToast(
                            requireActivity(), "Error",
                            it.localizedMessage,
                            MotionToastStyle.ERROR,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(
                                requireContext(),
                                www.sanju.motiontoast.R.font.helvetica_regular
                            )
                        )

                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}