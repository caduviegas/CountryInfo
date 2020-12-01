package br.com.innaval.countryinfo

import android.app.Person
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.IOException
import android.util.Log

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUm = findViewById<Button>(R.id.button_um)

        buttonUm.setOnClickListener {
            val abrirButton = Intent(this,Aba_dois_contry_info:: class.java )
            startActivity(abrirButton)
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

    val jsonFileString = getJsonDataFromAsset(this, "countries.json")


    val gson = Gson()
    val listPaisType = object : TypeToken<List<Pais>>() {}.type

    var paises: List<Pais> = gson.fromJson(jsonFileString, listPaisType)
     }
