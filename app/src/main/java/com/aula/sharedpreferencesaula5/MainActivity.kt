package com.aula.sharedpreferencesaula5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val botao : Button = findViewById(R.id.btnshared)
        val botaoload : Button = findViewById(R.id.btnsharedload)

        val nome : EditText = findViewById(R.id.txtnome)
        val email : EditText = findViewById(R.id.txtemail)

        val txtnomeload : TextView = findViewById(R.id.lblNomeload)
        val txtemailload : TextView = findViewById(R.id.emailload)

        val sharedpref = this.getSharedPreferences("pref", MODE_PRIVATE)
        val edit= sharedpref?.edit()


        botao.setOnClickListener {
            edit?.apply{
                putString("username", nome.text.toString())
                putString("email", email.text.toString())
                apply()
            }
        }

        botaoload.setOnClickListener{
            val nomeload = sharedpref?.getString("username", null).toString()
            val emailload = sharedpref?.getString("email", null).toString()


            txtnomeload.setText(nomeload.toString())
            txtemailload.setText(emailload.toString())

        }
    }
}