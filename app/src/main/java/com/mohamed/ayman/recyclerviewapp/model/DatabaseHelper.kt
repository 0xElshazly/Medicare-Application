package com.mohamed.ayman.recyclerviewapp.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,1)
{
    companion object{
        val DATABASE_NAME="Doctors.db"
        val TABLE_NAME="doctors_table"
        val COL_1="ID"
        val COL_2="firstname"
        val COL_3="lastname"
        val COL_4="address"
    }

    override fun onCreate(dp: SQLiteDatabase?) {
      dp?.execSQL("create table $TABLE_NAME( ID INTEGER PRIMARY KEY AUTOINCREMENT ,"
              + " firstname TEXT ,lastname TEXT , address TEXT ) ")
    }
    fun insertData(firstname:String,lastname:String,address:String){
        val dp=this.readableDatabase
        val contentValues=ContentValues()
        contentValues.put(COL_2,firstname)
        contentValues.put(COL_3,lastname)
        contentValues.put(COL_4,address)
        dp.insert(TABLE_NAME,null,contentValues)
    }
    fun updatatData(id:String,firstname:String,lastname:String,address:String):Boolean{
        val dp=this.readableDatabase
        val contentValues=ContentValues()
        contentValues.put(COL_1,id)
        contentValues.put(COL_2,firstname)
        contentValues.put(COL_3,lastname)
        contentValues.put(COL_4,address)
        dp.update(TABLE_NAME,contentValues,"ID = ?", arrayOf(id))
        return true
    }
    fun deleteData(id:String):Int{
        val dp=this.writableDatabase
       return dp.delete(TABLE_NAME,"ID = ?", arrayOf(id))


    }
    val allData:Cursor
        get() {
            val dp=this.writableDatabase
            val res=dp.rawQuery("select *from "+ TABLE_NAME,null)
            return res
        }


    override fun onUpgrade(dp: SQLiteDatabase?, p1: Int, p2: Int) {
        dp?.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME)
    }
}