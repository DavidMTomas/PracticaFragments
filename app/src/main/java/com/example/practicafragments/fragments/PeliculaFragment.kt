package com.example.practicafragments.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicafragments.R
import com.example.practicafragments.activities.DetalleActivity
import com.example.practicafragments.databinding.FragmentPeliculaBinding
import com.example.practicafragments.pojos.Pelicula


class PeliculaFragment : Fragment() {
    lateinit var binding: FragmentPeliculaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeliculaBinding.inflate(inflater, container, false)
        // MUESTRA LA INFO RECIBIDA
        var pelicula = arguments?.getSerializable("pelicula") as? Pelicula
        if (pelicula != null) {
            binding.ivImagen.setImageResource(pelicula.imagen)
            binding.tvCategoria.text = pelicula.categoria.toString()
        }
//        // DE INICIO SIN RECIBIR DE UNA ACTIVIDAD RPEVIAMENTE
//        val intent = Intent(requireActivity(), DetalleActivity::class.java)  // Contexto es 'requireActivity()' o 'activity'
//        intent.putExtra("pelicula", pelicula)  // Pasamos los datos
//        startActivity(intent)  // Iniciamos la Activity
        //ENVIA LA INFO A OTRA ACTIVIDAD
        binding.ivImagen.setOnClickListener {
            val intent = Intent(context, DetalleActivity::class.java)
            intent.putExtra("pelicula", pelicula)
            startActivity(intent)
        }
        return binding.root
    }

    //RECIBE LA INFO DE LA ACTIVIDAD
    companion object {
        @JvmStatic
        fun newInstance(pelicula: Pelicula): PeliculaFragment {
            val fragment = PeliculaFragment()
            val bundle = Bundle()
            bundle.putSerializable("pelicula", pelicula)
            fragment.arguments = bundle
            return fragment
        }
    }
}