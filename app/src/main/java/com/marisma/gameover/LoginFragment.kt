package com.marisma.gameover

import androidx.fragment.app.add
import androidx.fragment.app.commit
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        if (savedInstanceState == null) {


            //val bundle = bundleOf(ARG_Nombre to R.id.etUser)
            val bundle = bundleOf(ARG_Nombre to "Hola aaaa")

            //Botón de Play que lleva al fragmento GameFragment.
            binding.btnMenu.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                /*val result = "result"
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))*/

            }

/*
                childFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<MainFragment>(R.id.fcwMain, args = bundle)

                }

            }*/
        }
        return view
    }


}