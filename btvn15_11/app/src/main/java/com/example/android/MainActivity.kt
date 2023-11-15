package com.example.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.PopupMenu
import androidx.activity.ComponentActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    var listData: ArrayList<Contact> = ArrayList<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        var list: ArrayList<Contact> = dataList()
        listData = list

        val myAdapter: ContactAdapter = ContactAdapter(list, this)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = myAdapter



        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        myAdapter.setOnClickListener(object :
            ContactAdapter.OnClickListener {
            override fun onClick(position: Int, model: Contact) {
                val intent = Intent(this@MainActivity, ContactDetail::class.java)
                // Passing the data to the
                // EmployeeDetails Activity
                intent.putExtra("NAME_DETAIL", model.name)
                intent.putExtra("ID_DETAIL", model.ID )
                intent.putExtra("EMAIL_DETAIL", model.email)
                intent.putExtra("PHONE_DETAIL", model.phone)
                startActivity(intent)
            }
        })




    }


    fun dataList() : ArrayList<Contact>{
        var list: ArrayList<Contact> = ArrayList<Contact>()
        list.add(Contact("Tran Nam", "0000001", "nam123@gmail.com", "0836059063"))
        list.add(Contact("Tran Phuong", "0000003", "vh123@gmail.com", "091787063"))
        list.add(Contact("Tran Thao", "0009701", "vhjk123@gmail.com", "0452059063"))
        list.add(Contact("Thao Pham", "0234001", "vher3@gmail.com", "0916059034"))
        list.add(Contact("Le Duong", "0432001", "verf3@gmail.com", "0916000063"))
        list.add(Contact("Hoang tu", "0056701", "vve3@gmail.com", "0912059063"))
        list.add(Contact("Duong Hang", "0012801", "vwe333@gmail.com", "0916023463"))
        list.add(Contact("Chuong Duong", "0666601", "v12d3@gmail.com", "0923059063"))
        list.add(Contact("Le Hoan", "0834501", "dfe23@gmail.com", "0913489063"))
        list.add(Contact("Phuong Thao", "0035001", "5563@gmail.com", "0911234063"))
        list.add(Contact("Lao Nhao", "0056321", "ghu23@gmail.com", "0986059063"))
        list.add(Contact("Ba Ba Thap", "0023401", "5423@gmail.com", "0923679063"))
        return list
    }

}

