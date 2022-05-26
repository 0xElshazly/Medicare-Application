package com.mohamed.ayman.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamed.ayman.recyclerviewapp.adapter.DoctorRecyclerView
import com.mohamed.ayman.recyclerviewapp.adapter.OnDoctorItemClick
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentAdminDoctorBinding
import com.mohamed.ayman.recyclerviewapp.model.entity.Category
import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor
import com.mohamed.ayman.recyclerviewapp.model.local.DoctorDatabase
import com.mohamed.ayman.recyclerviewapp.model.local.LocalRepositoryImp
import kotlinx.coroutines.*


class adminDoctorFragment : Fragment(),OnDoctorItemClick {

    lateinit var binding: FragmentAdminDoctorBinding
    lateinit var localRepositoryImp: LocalRepositoryImp
    val userRecyclerView: DoctorRecyclerView by lazy { DoctorRecyclerView() }
    var userList: List<Doctor> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdminDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.adminRecyclerviewDoctor.adapter = userRecyclerView


        var dp = DoctorDatabase.getInstance(requireContext())
        localRepositoryImp = LocalRepositoryImp(dp)


        //binding.adminRecyclerviewDoctor.layoutManager = LinearLayoutManager(context)

        getAllDoctors()


        binding.addDoctorButton.setOnClickListener {
            var name = binding.nameDoctorEdit.text.toString()
            var location = binding.locationDoctorEdit.text.toString()
            var time = binding.timeDoctorEdit.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                localRepositoryImp.addOrUpdateDoctor(
                    Doctor(
                        0,
                        R.drawable.doctor7,
                        name.toString(),
                        location.toString(),
                        time.toString()
                    )
                )
//                localRepositoryImp.addOrUpdateDoctor(
//                    Doctor(
//                       0,
//                        R.drawable.doctor7,
//                        "Dr Mohamed Ayman",
//                        "Banha",
//                        "6PM - 12Pm"
//                    )
//                )
//                localRepositoryImp.addOrUpdateDoctor(
//                    Doctor(
//                        0,
//                        R.drawable.doctor2,
//                        "Dr Rahma Hussainn",
//                        "Egypt",
//                        "5PM - 10Pm"
//                    )
//                )
//                localRepositoryImp.addOrUpdateDoctor(
//                    Doctor(
//                        0,
//                        R.drawable.doctor3,
//                        "Dr Mohamed Abdallah",
//                        "Tukh",
//                        "8PM - 11Pm"
//                    )
//                )
//                localRepositoryImp.addOrUpdateDoctor(
//                    Doctor(
//                        0,
//                        R.drawable.doctor1,
//                        "Dr Sara Atef",
//                        "Cairo",
//                        "6PM - 10Pm"
//                    )
//                )
//                localRepositoryImp.addOrUpdateDoctor(
//                    Doctor(
//                        0,
//                        R.drawable.doctor6,
//                        "Dr Omneya Ahmed",
//                        "Egypt",
//                        "5PM - 10Pm"
//                    )
//                )
//
            }

            binding.nameDoctorEdit.setText("")
            binding.locationDoctorEdit.setText("")
            binding.timeDoctorEdit.setText("")
        }

        getAllDoctors()
        userRecyclerView.onListItemClick = this
    }
    fun getAllDoctors() {
        GlobalScope.launch(Dispatchers.IO) {
            var returnedDoctors = async {
                localRepositoryImp.getAllDoctors()
            }
            withContext(Dispatchers.Main) {
                binding.adminProgressBar.visibility = View.VISIBLE
                userList = returnedDoctors.await()
                binding.adminProgressBar.visibility = View.GONE
                userRecyclerView.setList(userList)
            }
        }
    }
    override fun onItemClick(user: Doctor) {

        //findNavController().navigate(R.id.action_adminCategoryFragment_to_adminDoctorFragment)
        GlobalScope.launch(Dispatchers.IO) {
            localRepositoryImp.deleteDoctor(user)
        }

        Toast.makeText(
            context,
            "Doctor Is Deleted Successfully",
            Toast.LENGTH_SHORT
        )
            .show()
        getAllDoctors()
    }
}