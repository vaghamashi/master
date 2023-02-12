package com.example.master_of

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.master_of.Adapters.StudentAdapter
import com.example.master_of.Database.Database
import com.example.master_of.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var database: Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bindhing = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindhing.root)

        database = Database(applicationContext)
        bindhing.btnadd.setOnClickListener {

            database.adddata(
                bindhing.editName.text.toString(),
                bindhing.editSurname.text.toString(),
                bindhing.editAdresss.text.toString(),
                bindhing.editPhoneno.text.toString().toInt()
            )
        }
        bindhing.btnshow.setOnClickListener {

            var list = database.showData()
            bindhing.recylerview.layoutManager = LinearLayoutManager(applicationContext)
            bindhing.recylerview.adapter = StudentAdapter(list)
        }

    }
}