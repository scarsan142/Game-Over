package com.marisma.gameover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.text.Html
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentCreditBinding
import com.marisma.gameover.databinding.FragmentMainBinding

class CreditFragment : Fragment() {
    private var _binding : FragmentCreditBinding? = null
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
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        /*
        // Recuperar el nombre del usuario de la actividad anterior (MainActivity)
        val name = arguments?.getString("Name")

        // Verificar si el nombre del usuario no es nulo
        name?.let {
            // Crear un mensaje de bienvenida personalizado con el nombre del usuario
            val welcomeMessage = "¡Bienvenido, $name!"
            // Actualizar la interfaz de usuario con el mensaje de bienvenida
            binding.tvWelcome.text = welcomeMessage
        }*/

        // Configurar la acción de clic para el botón de contacto
        binding.contactButton.setOnClickListener {
            // Lanzar un intent implícito de envío de correo electrónico
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tucorreo@example.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta desde la aplicación")
            //emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, soy $name y quisiera consultar sobre...")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, soy name y quisiera consultar sobre...")

            // Verificar si hay una aplicación de correo electrónico disponible
            if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(emailIntent)
            }
        }

        return binding.root
    }
}