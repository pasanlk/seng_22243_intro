package com.example.seng22243intro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.seng22243intro.api.UserAPIService
import com.example.seng22243intro.databinding.FragmentFirstBinding
import com.example.seng22243intro.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val userAPIService=UserAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //next




        binding.buttonFirst.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            val user=userAPIService.getUser("2");
            Log.i("FirstFragment", "onviewcreated")
            user.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val body = response.body()
                    Log.i("FirstFragment", "created")
                    body?.let {
                        Log.i("FirstFragment", it.name)
                        binding.textviewFirst.text = it.name

                        binding.textviewfourth.text = it.email

                        binding.textviewThird.text = it.username




                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("FirstFragment", "error")
                }

            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}