package com.mohamed.ayman.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mohamed.ayman.recyclerviewapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() ,View.OnClickListener {

    val username: String = "1"
    val password: String = "1"
    val adminUsername: String = "admin"
    val adminPassword: String = "admin"
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.loginButton.setOnClickListener {
//            validateLogin(it)
//            if (!binding.usernameEdit.text.toString().isNullOrEmpty() && !binding.passwordEdit.text.toString()
//                    .isNullOrEmpty()
//            ) {
//                if (binding.usernameEdit.text.toString().equals(username) && binding.passwordEdit.text.toString()
//                        .equals(password)
//                ) {
//                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//                    findNavController().navigate(R.id.action_loginFragment_to_categoryFragment)
//                    //intent.putExtra("Username", binding.usernameEdit.text.toString())
//
//                } else {
//                    Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
//                }
//            }
//            else if (!binding.usernameEdit.text.toString().isNullOrEmpty() && !binding.passwordEdit.text.toString()
//                    .isNullOrEmpty()
//            ) {
//                if (binding.usernameEdit.text.toString().equals(adminUsername) && binding.passwordEdit.text.toString()
//                        .equals(adminPassword)
//                ) {
//                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//                    findNavController().navigate(R.id.action_loginFragment_to_adminCategoryFragment)
//                    //intent.putExtra("Username", binding.usernameEdit.text.toString())
//
//                } else {
//                    Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
//                }
//            }


//        }


        binding.signupButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.forgetPasswordText.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_passwordRecoveryFragment)
        }
        binding.loginButton.setOnClickListener (this)

    }
    override fun onClick(view: View?) {
        when (view?.id) {
//            R.id.username_text -> {
//                Toast.makeText(context, "Username", Toast.LENGTH_SHORT).show()
//            }
//            R.id.password_text -> {
//                Toast.makeText(context, "Password", Toast.LENGTH_SHORT).show()
//            }
            R.id.login_button -> {

                if (binding.usernameEdit.text.toString()
                        .equals("admin") && binding.passwordEdit.text.toString().equals("admin")
                ) {
                    Toast.makeText(context, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_adminCategoryFragment)
//                    var action = LoginFragmentDirections.actionLoginFragmentToAdminFragment()
//                    findNavController().navigate(action)

                } else if (binding.usernameEdit.text.toString()
                        .equals(username) && binding.passwordEdit.text.toString().equals(password)
                ) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_categoryFragment)

                }

            }
        }


    }
}

















//    private fun validateLogin(view: View) {
//        if (!binding.usernameEdit.text.toString().isNullOrEmpty() && !binding.passwordEdit.text.toString()
//                .isNullOrEmpty()
//        ) {
//            if (binding.usernameEdit.text.toString().equals(username) && binding.passwordEdit.text.toString()
//                    .equals(password)
//            ) {
//                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_loginFragment_to_categoryFragment)
//                //intent.putExtra("Username", binding.usernameEdit.text.toString())
//
//            } else {
//                Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
//            }
//        }
//        else if (!binding.usernameEdit.text.toString().isNullOrEmpty() && !binding.passwordEdit.text.toString()
//                .isNullOrEmpty()
//        ) {
//            if (binding.usernameEdit.text.toString().equals(adminUsername) && binding.passwordEdit.text.toString()
//                    .equals(adminPassword)
//            ) {
//                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_loginFragment_to_adminCategoryFragment)
//                //intent.putExtra("Username", binding.usernameEdit.text.toString())
//
//            } else {
//                Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
//    }
