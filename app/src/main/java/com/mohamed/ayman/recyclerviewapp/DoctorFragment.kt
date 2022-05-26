package com.mohamed.ayman.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamed.ayman.recyclerviewapp.adapter.DoctorRecyclerView
import com.mohamed.ayman.recyclerviewapp.adapter.OnDoctorItemClick

import com.mohamed.ayman.recyclerviewapp.databinding.FragmentDoctorBinding

import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor
import com.mohamed.ayman.recyclerviewapp.model.local.DoctorDatabase
import com.mohamed.ayman.recyclerviewapp.model.local.LocalRepositoryImp
import kotlinx.coroutines.*

class DoctorFragment : Fragment() , OnDoctorItemClick {

    lateinit var binding: FragmentDoctorBinding

    lateinit var localRepositoryImp: LocalRepositoryImp
    var data: List<Doctor> = emptyList()
   // val adapter = DoctorAdapter(data)


    val userRecyclerView: DoctorRecyclerView by lazy { DoctorRecyclerView() }
    var userList: List<Doctor> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO [1] Getting the Recycler View by its ID
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewdoctor)

        // TODO [2] Create LayoutManager
        //recyclerView.layoutManager= GridLayoutManager(this, 2)
        //binding.recyclerviewdoctor.layoutManager = LinearLayoutManager(context)

        binding.recyclerviewdoctor.adapter = userRecyclerView


        var dp = DoctorDatabase.getInstance(requireContext())
        localRepositoryImp = LocalRepositoryImp(dp)


        //binding.adminRecyclerviewDoctor.layoutManager = LinearLayoutManager(context)

        getAllDoctors()
        // TODO [3] Create an ArrayList to hold the Data





        //dp.doctorDAO().addOrUpdateDoctor(Doctor(0, R.drawable.doctor7, "Mohamed", "Egypt", "5Am"))



//        val data = ArrayList<Doctor>()
//
//        // TODO [4] Add Flower image to the Drawable &
//        // TODO [5] Insert Data to the Array List
//        data.add(Doctor(0, R.drawable.doctor7, "Egypt", "5AM - 6PM", "k"))
//        data.add(Doctor(R.drawable.doctor3, "Dr. Ahmed Said", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor4, "Dr. Nagy Ahmed", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor5, "Dr. Mona Arafa", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor6, "Dr. Mohamed Ayman", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor7, "Dr. Ahmed Said", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor1, "Dr. Nagy Ahmed", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor2, "Dr. Mona Arafa", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor3, "Dr. Mohamed Ayman", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor4, "Dr. Ahmed Said", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor5, "Dr. Nagy Ahmed", "Egypt", "5AM - 6PM"))
//        data.add(Doctor(R.drawable.doctor6, "Dr. Mona Arafa", "Egypt", "5AM - 6PM"))

        // TODO [6] Create an adapter reference

        getAllDoctors()
        // TODO [7] Setting up the Adapter with the RecyclerView
        userRecyclerView.onListItemClick = this
    }
    fun getAllDoctors() {
        GlobalScope.launch(Dispatchers.IO) {
            var returnedUsers = async {
                localRepositoryImp.getAllDoctors()
            }
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.VISIBLE
                userList = returnedUsers.await()
                binding.progressBar.visibility = View.GONE
                userRecyclerView.setList(userList)
            }
        }
    }

    override fun onItemClick(user: Doctor) {
        findNavController().navigate(R.id.action_doctorFragment_to_aboutDoctorFragment3)
    }

}
