package com.example.practicafragments.pojos

import com.example.practicafragments.R

class DatosCine {
    companion object{
        val peliculas = listOf(
            Pelicula(
                nombre = "Joker",
                duracion = 122,
                categoria = Categoria.DRAMA,
                imagen = R.drawable.joker,
                reparto = Reparto(
                    director = "Todd Phillips",
                    productor = "Bradley Cooper",
                    actorPrincipal = "Joaquin Phoenix"
                )
            ),
            Pelicula(
                nombre = "Mad Max: Fury Road",
                duracion = 120,
                categoria = Categoria.ACCIÓN,
                imagen = R.drawable.mad_max,
                reparto = Reparto(
                    director = "George Miller",
                    productor = "Doug Mitchell",
                    actorPrincipal = "Tom Hardy"
                )
            ),
            Pelicula(
                nombre = "Toy Story",
                duracion = 81,
                categoria = Categoria.FANTASÍA,
                imagen = R.drawable.toy_story,
                reparto = Reparto(
                    director = "John Lasseter",
                    productor = "Pixar Animation Studios",
                    actorPrincipal = "Tom Hanks"
                )
            ),
            Pelicula(
                nombre = "X-Men: Days of Future Past",
                duracion = 132,
                categoria = Categoria.CIENCIA,
                imagen = R.drawable.xmen,
                reparto = Reparto(
                    director = "Bryan Singer",
                    productor = "Lauren Shuler Donner",
                    actorPrincipal = "Hugh Jackman"
                )
            )
        )

    }
}