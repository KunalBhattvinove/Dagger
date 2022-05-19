package com.example.mydagger2.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.mydagger2.db.FakeDB
import com.example.mydagger2.db.FakeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {
   @Provides
    @Singleton
    fun getDao(fakeDB: FakeDB): FakeDao
    {
        return fakeDB.getDao()
    }

    @Provides
    @Singleton
    fun getDatabase():FakeDB
    {
        return FakeDB.getDatabaseInstance(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }
   /* fun provideFakeDB(context:Context) : FakeDB
    {
        return Room.databaseBuilder(context, FakeDB::class.java,"fake_db").build()

    }*/
}