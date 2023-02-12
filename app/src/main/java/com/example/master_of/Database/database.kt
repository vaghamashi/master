package com.example.master_of.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.master_of.StudentModel
import java.util.ArrayList
import kotlin.collections.ArrayList as ArrayList1

class Database(context: Context?) : SQLiteOpenHelper(context, "my data.db", null, 1) {

    var context = context

    override fun onCreate(db: SQLiteDatabase?) {

        var sql =
            "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT ,name  TEXT , surname TEXT, address  TEXT,phoneno INTEGER)"
        db?.execSQL(sql)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun adddata(name: String, surname: String, address: String, phoneno: Int) {


        var db = writableDatabase
        var values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("address", address)
        values.put("phoneno", phoneno)
        db.insert("student", null, values)

    }

    fun showData(): ArrayList<StudentModel> {

        var stdList = ArrayList<StudentModel>()
        var db = readableDatabase
        var sql = "SELECT * FROM student"
        var cursor: Cursor = db.rawQuery(sql, null)
        cursor.moveToNext()

        for (i in 0..cursor.count - 1) {

            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var sruname = cursor.getString(2)
            var adress = cursor.getString(3)
            var phoneno = cursor.getInt(4)
            var std = StudentModel(id, name, sruname, adress, phoneno)
            stdList.add(std)
            cursor.moveToNext()
        }
        return stdList
    }

    fun updateDate(name: String,surname: String,address: String,id:Int,phoneno: Int) {

        var db =writableDatabase
        var values = ContentValues()
        values.put("name",name)
        values.put("sruname",surname)
        values.put("adress",address)
        values.put("phoneno",phoneno)
        db.update("student",values,"id=$id",null)

    }


}
