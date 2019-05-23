package com.example.scanforsecurity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)

                val lista = findViewById<ListView>(R.id.listDevices)

                lista.adapter = DevicesList(this)


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                val lista = findViewById<ListView>(R.id.listDevices)

                lista.adapter = WerableList(this)


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)

                val lista = findViewById<ListView>(R.id.listDevices)

                lista.adapter = NotificationList(this)


                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private class DevicesList(context: Context): BaseAdapter(){

        private val devicesNames = arrayListOf<String>(
            "Quarto","Fogão","Janela"
        )
        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return devicesNames.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST String"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowList =  layoutInflater.inflate(R.layout.row_list, viewGroup, false)

            val nameTextView = rowList.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = devicesNames.get(position)
            return rowList

//            val textView = TextView(mContext)
//            textView.text = "Here"
//            return textView
        }


    }

    private class WerableList(context: Context): BaseAdapter(){

        private val names = arrayListOf<String>(
            "João","Maria"
        )
        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST String"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowList =  layoutInflater.inflate(R.layout.row_list, viewGroup, false)

            val nameTextView = rowList.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)
            return rowList

//            val textView = TextView(mContext)
//            textView.text = "Here"
//            return textView
        }


    }

    private class NotificationList(context: Context): BaseAdapter(){

        private val notifications = arrayListOf<String>(
            "João está perto do Fogão","Maria esta na área da Piscina","João está na área da Janela"
        )
        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return notifications.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST String"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowList =  layoutInflater.inflate(R.layout.row_list, viewGroup, false)

            val nameTextView = rowList.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = notifications.get(position)
            return rowList

//            val textView = TextView(mContext)
//            textView.text = "Here"
//            return textView
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)


        addButton.setOnClickListener {
            val i = Intent(applicationContext, CadastroActivity::class.java)
            i.putExtra("caller", "CadastroActivity")
            startActivity(i)
            finish()
        }

        val lista = findViewById<ListView>(R.id.listDevices)

        lista.adapter = NotificationList(this)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
