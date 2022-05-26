package com.mohamed.ayman.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentSignupBinding



class SignupFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSignupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.loginButton.setOnClickListener {
//            intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//        binding.signupButton.setOnClickListener {
//            intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

    }
}