package com.mohamed.ayman.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentAboutDoctorBinding


class AboutDoctorFragment : Fragment() {

    var username: String? = null
    lateinit var binding: FragmentAboutDoctorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAboutDoctorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username= arguments?.getString("doctorname")
        binding.DoctornameText.text=username

        binding.backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_aboutDoctorFragment3_to_doctorFragment)
        }
        binding.takeAppointment.setOnClickListener {
            findNavController().navigate(R.id.action_aboutDoctorFragment3_to_reservationFragment)
        }

    }
}