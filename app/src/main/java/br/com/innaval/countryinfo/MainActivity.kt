package br.com.innaval.countryinfo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.IOException
import android.util.Log
import android.widget.ArrayAdapter

import android.widget.Spinner

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(this, "countries.json")


        val gson = Gson()
        val listPaisType = object : TypeToken<List<Pais>>() {}.type

        var paises: List<Pais> = gson.fromJson(jsonFileString, listPaisType)
        Log.i("JSON", jsonFileString)

        val spinnerPais = findViewById<Spinner>(R.id.spinner_pais)
        val options = paises.map{ it.nome }
        spinnerPais.adapter = ArrayAdapter<String>(this, R.layout.spinner_item,options)

        val buttonUm = findViewById<Button>(R.id.button_um)

        buttonUm.setOnClickListener {
            val posicao = spinnerPais.selectedItemPosition
            val pais = paises[posicao]
            val intent = Intent(this,PaisDetalheActivity:: class.java )
            intent.putExtra("PAIS",pais)
            startActivity(intent)
        }

    }

     fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
