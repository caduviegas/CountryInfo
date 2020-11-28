package br.com.innaval.countryinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
}