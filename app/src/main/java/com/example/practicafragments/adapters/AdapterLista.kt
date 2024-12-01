package com.example.practicafragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicafragments.R
import com.example.practicafragments.databinding.ItemListaBinding
import com.example.practicafragments.pojos.Pelicula

class AdapterLista(val lista: List<Pelicula>, val evento: EventoLista) :
    RecyclerView.Adapter<AdapterLista.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListaBinding.bind(view)
        fun render(pelicula: Pelicula) {
            binding.tvNombre.text = pelicula.nombre
            binding.tvDuracion.text = pelicula.duracion.toString()
            binding.tvCategoria.text = pelicula.categoria.toString()
            setEvento(pelicula)
        }

        private fun setEvento(pelicula: Pelicula) {
            binding.root.setOnClickListener {
                evento.enviarEventoLista(pelicula)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        )
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(lista[position])
    }
}