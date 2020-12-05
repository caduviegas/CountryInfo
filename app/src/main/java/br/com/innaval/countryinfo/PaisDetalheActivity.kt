package br.com.innaval.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class PaisDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paises_detalhes_activity)
        val pais:Pais? = intent.extras?.getParcelable("PAIS")
        val tvNome = findViewById<TextView>(R.id.textview_nome)
        val tvContinente = findViewById<TextView>(R.id.textview_continente)
        val tvPopulacao = findViewById<TextView>(R.id.textview_populacao)
        val tvCapital = findViewById<TextView>(R.id.textview_capital)
        val tvArea = findViewById<TextView>(R.id.textview_area)
        val tvCoordenadas = findViewById<TextView>(R.id.textview_coordenadas)
        val llIdiomas = findViewById<LinearLayout>(R.id.linearlayout_idioma)
        val ivBandeira = findViewById<ImageView>(R.id.imagemview_bandeira)


        pais?.let {

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            val areaLimitada =df.format(pais.area)
            val populacaoLimitada = df.format(pais.populacao)



            tvNome.text = it.nome
            tvContinente.text = it.continente
            tvPopulacao.text = populacaoLimitada
            tvCapital.text = it.capital
            tvArea.text = areaLimitada

            it.idiomas.forEach {

                val tvIdioma = TextView(this)
                tvIdioma.text = it.nome
                llIdiomas.addView(tvIdioma)
            }

            val lat = it.coordenadas[0]
            val lng = it.coordenadas[1]
            val latitudesLimitada = df.format(lat)
            val longitudeLimitada = df.format(lng)
            val latitude = latitudesLimitada
            val longitude = longitudeLimitada
            val coordenadas = "Latitude: $latitude\n Longitude: $longitude"

            ivBandeira?.let{bandeira ->

            }

        }

    }
}