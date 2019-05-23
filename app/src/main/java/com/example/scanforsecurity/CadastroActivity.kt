package com.example.scanforsecurity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val i = Intent(applicationContext, HomeActivity::class.java)
            i.putExtra("caller", "HomeActivity")
            startActivity(i)
            finish()
        }
    }
}
