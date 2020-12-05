package br.com.innaval.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class PaisDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paises_detalhes_activity)
        val pais:Pais? = intent.extras?.getParcelable("PAIS")
        val nome = findViewById<TextView>(R.id.textview_nome)
        val continente = findViewById<TextView>(R.id.textview_continente)
        val populacao = findViewById<TextView>(R.id.textview_populacao)
        val capital = findViewById<TextView>(R.id.textview_capital)
        val area = findViewById<TextView>(R.id.textview_area)
        val coordenadas = findViewById<TextView>(R.id.textview_coordenadas)
        val llIdiomas = findViewById<LinearLayout>(R.id.linearlayout_idioma)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val areaLimitada =df.format(area)
        val populacaoLimitada = df.format(populacao)
        val latitudeLimitada = df.format(coordenadas)



        pais?.let {
            nome.text = it.nome
            continente.text = it.continente
            populacao.text = populacaoLimitada
            capital.text = it.capital
            area.text = areaLimitada

            it.idiomas.forEach {

                val tvIdioma = TextView(this)
                tvIdioma.text = it.nome
                llIdiomas.addView(tvIdioma)
            }

            val lat = it.coordenadas[0]
            val lng = it.coordenadas[1]
            val latitudeLimitada = df.format(lat)
            val longitudeLimitada = df.format(lng)
            val latitude = latitudeLimitada
            val longitude = longitudeLimitada
            val coordenadas = "Latitude: $latitude\n Longitude: $longitude"

        }

    }
}