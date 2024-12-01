package com.example.practicafragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicafragments.R
import com.example.practicafragments.adapters.AdapterLista
import com.example.practicafragments.adapters.EventoLista
import com.example.practicafragments.databinding.FragmentListaBinding
import com.example.practicafragments.pojos.DatosCine


class ListaFragment : Fragment() {
    lateinit var binding:FragmentListaBinding
    lateinit var adapterLista: AdapterLista
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater,container,false)
        var eventoLista= requireActivity() as EventoLista

        adapterLista= AdapterLista(DatosCine.peliculas, eventoLista)
        linearLayoutManager= LinearLayoutManager(context)


        binding.rvLista.apply {
            adapter=adapterLista
            layoutManager=linearLayoutManager
        }


        

        return binding.root
    }


}