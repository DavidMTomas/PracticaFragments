package com.example.practicafragments.pojos

import java.io.Serializable

data class Pelicula(var nombre:String, var duracion:Int, var categoria:Categoria, var imagen:Int, var reparto:Reparto):Serializable {
}