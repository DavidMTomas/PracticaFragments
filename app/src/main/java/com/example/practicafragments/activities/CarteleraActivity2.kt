package com.example.practicafragments.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicafragments.R
import com.example.practicafragments.adapters.EventoLista
import com.example.practicafragments.databinding.ActivityCartelera2Binding
import com.example.practicafragments.fragments.ListaFragment
import com.example.practicafragments.fragments.PeliculaFragment
import com.example.practicafragments.pojos.Pelicula

class CarteleraActivity2 : AppCompatActivity(), EventoLista {
    lateinit var binding: ActivityCartelera2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityCartelera2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        if (savedInstanceState ==null){
//            val transaccio = supportFragmentManager.beginTransaction()
//            transaccio.replace(R.id.contenedorListaFragment,ListaFragment())
//            transaccio.commitNow()
//        }
    }


    override fun enviarEventoLista(pelicula: Pelicula) {
        val fragment  = PeliculaFragment.newInstance(pelicula)
        val envio = supportFragmentManager.beginTransaction()
        envio.replace(R.id.contenedorPeliculaFragment,fragment)
        envio.commit()
       Toast.makeText(this,"Evento pulsado ${pelicula.nombre}",Toast.LENGTH_LONG).show()
    }
}