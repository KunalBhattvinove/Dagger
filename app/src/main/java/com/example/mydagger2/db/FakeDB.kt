package com.example.mydagger2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mydagger2.model.Product

@Database(entities = [Product::class], version = 1)
abstract class FakeDB: RoomDatabase() {

    abstract fun getDao():FakeDao
    companion object {
        private var dbInstance: FakeDB? = null
        fun getDatabaseInstance(context: Context): FakeDB {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    FakeDB::class.java,
                    "fake_db"
                )
                    .build()
            }
            return dbInstance!!
        }
    }
}