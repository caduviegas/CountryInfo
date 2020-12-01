package br.com.innaval.countryinfo

data class Pais (
        val nome:String,
        val continente:String,
        val populacao:Double,
        val capitao:String,
        val area:Double,
        val coordenadas: List<Double>,
        val idiomas:List<Idioma>

)