package com.example.practicafragments.activities

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicafragments.R
import com.example.practicafragments.databinding.ActivityCartelera2Binding
import com.example.practicafragments.databinding.ActivityDetalleBinding
import com.example.practicafragments.databinding.DialogoBinding
import com.example.practicafragments.pojos.Pelicula
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val pelicula=intent.getSerializableExtra("pelicula") as Pelicula
        Toast.makeText(this,"La peli es ${pelicula.nombre}", Toast.LENGTH_LONG).show()


        binding.tvPelicula.text=pelicula.nombre
        binding.tvDuracion.setText("${binding.tvDuracion.text}  ${pelicula.duracion.toString()}")
        binding.tvCategoria.text=pelicula.categoria.toString()
        binding.ivImagen.setImageResource(pelicula.imagen)
        binding.tvReparto.text="Director ${pelicula.reparto.director} \n Productor ${pelicula.reparto.productor}" +
                "\n Actor principal ${pelicula.reparto.actorPrincipal}"


        binding.btnDialogo.setOnClickListener {
            val dialogo=DialogoBinding.inflate(layoutInflater)
            MaterialAlertDialogBuilder(this)
                .setTitle("Disponibilidad")
                .setView(dialogo.root)
                .setPositiveButton("aceptar",DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                .setCancelable(false)
                .show()
        }

    }
}