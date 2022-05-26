package com.mohamed.ayman.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.mohamed.ayman.recyclerviewapp.adapter.OnListItemClick
import com.mohamed.ayman.recyclerviewapp.adapter.UserRecyclerView
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentAdminCategoryBinding

import com.mohamed.ayman.recyclerviewapp.model.entity.Category

import com.mohamed.ayman.recyclerviewapp.model.local.CategoryDatabase
import com.mohamed.ayman.recyclerviewapp.model.local.LocalRepositoryImp2
import kotlinx.coroutines.*


class adminCategoryFragment : Fragment(), OnListItemClick {

    lateinit var binding: FragmentAdminCategoryBinding
    var userList: List<Category> = emptyList()
    var username: String? = null

    // take object from recycler view
    // take an object from recycler view if i click the button
    val userRecyclerView: UserRecyclerView by lazy { UserRecyclerView() }
    lateinit var localRepositoryImp2: LocalRepositoryImp2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = CategoryDatabase.getInstance(requireContext())

        localRepositoryImp2 = LocalRepositoryImp2(db)

        binding.showdataRecycler.adapter = userRecyclerView

        getAllUsers()

        binding.addButton.setOnClickListener {

            var message = binding.messageEdit.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                localRepositoryImp2.insertOrUpdateUser(
                    Category(
                        0,
                        username.toString(),
                        message,
                        R.drawable.cardiology
                    )
                )
//                localRepositoryImp2.insertOrUpdateUser(
//                    Category(
//                        0,
//                        username.toString(),
//                        "Kidneys",
//                        R.drawable.kidneys
//                    )
//                )
//
            }


            binding.messageEdit.setText("")
        }

        binding.updateButton.setOnClickListener {
            var message = binding.messageEdit.text.toString()
//            GlobalScope.launch(Dispatchers.IO) {
//                localRepositoryImp2.update(
//                    Category(
//                        0,
//                        username.toString(),
//                        message,
//                        R.drawable.cardiology
//                    )
//                )
////
//            }


        }
        getAllUsers()

        userRecyclerView.onListItemClick = this

    }

    fun getAllUsers() {
        GlobalScope.launch(Dispatchers.IO) {
           // async -> wait to return all user (data)
            var returnedUsers = async {
                localRepositoryImp2.getUsers()
            }
            // if it take time "In Foreground"
            // use with global scope or suspend function
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.VISIBLE
                // wait to return all user
                userList = returnedUsers.await()
                binding.progressBar.visibility = View.GONE
                userRecyclerView.setList(userList)
            }
        }

    }

    override fun onItemClick(user: Category) {

        findNavController().navigate(R.id.action_adminCategoryFragment_to_adminDoctorFragment)
//        GlobalScope.launch(Dispatchers.IO) {
//            localRepositoryImp2.deleteUser(user)
//        }
//
//        Toast.makeText(
//            context,
//            "User Is Deleted Successfully",
//            Toast.LENGTH_SHORT
//        )
//            .show()
//        getAllUsers()
    }

}