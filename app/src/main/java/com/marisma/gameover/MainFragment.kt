package com.marisma.gameover

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentMainBinding


const val ARG_Nombre = "nombre"
class MainFragment : Fragment() {
    private var nombre: String? = null

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey"){
            requestKey, bundle -> val result = bundle.getString("bundleKey")
            Log.i("Saul",  result.orEmpty())
        }
        /**arguments?.let {

            nombre=it.getString(ARG_Nombre)
           // Log.i("Saul",  nombre.orEmpty())
        }**/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Saul",  "Entro")
        Log.i("Saul",  nombre.orEmpty())
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)

        //Botón de Play que lleva al fragmento GameFragment.
        binding.btnCredits.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_creditFragment)
        }
        binding.btnExit.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment2)
        }
        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance(param1: String) = MainFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_Nombre, param1)
            }
        }

    }
}