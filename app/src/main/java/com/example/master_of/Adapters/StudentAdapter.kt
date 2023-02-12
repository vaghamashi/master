package com.example.master_of.Adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.master_of.Database.Database
import com.example.master_of.R
import com.example.master_of.StudentModel
import java.util.ArrayList

class StudentAdapter(list: ArrayList<StudentModel>) :
    RecyclerView.Adapter<StudentAdapter.StudentHolder>() {


    var list = list
    lateinit var context: Context
    lateinit var database: Database

    class StudentHolder(itemView: View) : ViewHolder(itemView) {

        var txtid = itemView.findViewById<TextView>(R.id.txtid)
        var txtname = itemView.findViewById<TextView>(R.id.txtname)
        var txtsruname = itemView.findViewById<TextView>(R.id.txtsruname)
        var txtadress = itemView.findViewById<TextView>(R.id.txtaddress)
        var txtphoneno = itemView.findViewById<TextView>(R.id.txtphoneno)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {

        context = parent.context
        return StudentHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.std_item, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {

        database = Database(context)

        holder.txtid.text = list.get(position).id.toString()
        holder.txtname.text = list.get(position).name
        holder.txtsruname.text = list.get(position).sruname
        holder.txtadress.text = list.get(position).adress
        holder.txtphoneno.text = list.get(position).phoneno.toString()


        holder.itemView.setOnClickListener {

            var dialog = Dialog(context)
            dialog.setContentView(R.layout.data)

            var did = dialog.findViewById<TextView>(R.id.edtid)
            var dname = dialog.findViewById<TextView>(R.id.editName)
            var dsruname = dialog.findViewById<TextView>(R.id.editSurname)
            var dadress = dialog.findViewById<TextView>(R.id.editAdresss)
            var dphoneno = dialog.findViewById<TextView>(R.id.editPhoneno)
            var btnuapdat = dialog.findViewById<TextView>(R.id.btnupdate)


            did.text = list.get(position).id.toString()
            dname.setText(list.get(position).name)
            dsruname.setText(list.get(position).sruname)
            dadress.setText(list.get(position).adress)
            dphoneno.setText(list.get(position).phoneno)

            btnuapdat.setOnClickListener {


                database.updateDate(
                    dname.text.toString(),
                    dsruname.text.toString(),
                    dadress.text.toString(),
                    dphoneno.text.toString().toInt(),
                    did.text.toString().toInt()
                )
                dialog.dismiss()
            }


        }


    }


}


