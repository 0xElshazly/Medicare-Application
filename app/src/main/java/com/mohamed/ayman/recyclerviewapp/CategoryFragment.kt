package com.mohamed.ayman.recyclerviewapp


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.mohamed.ayman.recyclerviewapp.adapter.OnListItemClick
import com.mohamed.ayman.recyclerviewapp.adapter.UserRecyclerView
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentCategoryBinding
import com.mohamed.ayman.recyclerviewapp.model.entity.Category
import com.mohamed.ayman.recyclerviewapp.model.local.CategoryDatabase
import com.mohamed.ayman.recyclerviewapp.model.local.LocalRepositoryImp2
import kotlinx.coroutines.*


class CategoryFragment : Fragment(), OnListItemClick {

    lateinit var binding: FragmentCategoryBinding
    lateinit var toggel: ActionBarDrawerToggle
    var specialistName: String? = null
    var userList: List<Category> = emptyList()
    val userRecyclerView: UserRecyclerView by lazy { UserRecyclerView() }
    lateinit var localRepositoryImp2: LocalRepositoryImp2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO [1] Getting the Recycler View by its ID
        //val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)

        specialistName = arguments?.getString("specialist_name")

        // TODO [2] Create LayoutManager
        binding.showdataRecycler.layoutManager = GridLayoutManager(context, 3)

        // TODO [3] Create an ArrayList to hold the Data
//        val data=ArrayList<Category>()
//
//        // TODO [4] Add Flower image to the Drawable &
//        // TODO [5] Insert Data to the Array List
//        data.add(Category(0,"Cardiology","Cardiology",R.drawable.cardiology))
//        data.add(Category(0,"Cardiology","Dentist",R.drawable.dentist))
//        data.add(Category(0,"Cardiology","Eyes",R.drawable.eyes))

//        data.add(Category(R.drawable.dentist,"Dentist"))
//        data.add(Category(R.drawable.kidneys,"Kidneys"))
//        data.add(Category(R.drawable.eyes,"Eyes"))
//        data.add(Category(R.drawable.kidneys,"Kidneys"))
//        data.add(Category(R.drawable.eyes,"Eyes"))
//        data.add(Category(R.drawable.cardiology,"Cardiology"))
//        data.add(Category(R.drawable.dentist,"Dentist"))
//        data.add(Category(R.drawable.kidneys,"Kidneys"))
////        // TODO [6] Create an adapter reference
        //val adapter = CategoryAdapter(data)

        // TODO [7] Setting up the Adapter with the RecyclerView
        //binding.showdataRecycler.adapter = adapter
        binding.showdataRecycler.adapter = userRecyclerView

        toggel = ActionBarDrawerToggle(
            context as Activity?,
            binding.drawerLayout,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggel)

        toggel.syncState()
        setHasOptionsMenu(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_mune -> Toast.makeText(context, "home", Toast.LENGTH_LONG).show()
            }
            true
        }

        userRecyclerView.onListItemClick = this

        var db = CategoryDatabase.getInstance(requireContext())

        localRepositoryImp2 = LocalRepositoryImp2(db)
        getAllUsers()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggel.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)

    }

    fun getAllUsers() {
        GlobalScope.launch(Dispatchers.IO) {
            var returnedUsers = async {
                localRepositoryImp2.getUsers()
            }
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.VISIBLE
                userList = returnedUsers.await()
                binding.progressBar.visibility = View.GONE
                userRecyclerView.setList(userList)
            }
        }
    }

    override fun onItemClick(user: Category) {

        findNavController().navigate(R.id.action_categoryFragment_to_doctorFragment)
    }
}