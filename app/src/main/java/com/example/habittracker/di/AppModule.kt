package com.example.habittracker.di

import android.content.Context
import androidx.room.Room
import com.example.habittracker.data.local.HabitDatabase
import com.example.habittracker.data.local.dao.HabitDao
import com.example.habittracker.data.repository.HabitRepositoryImpl
import com.example.habittracker.domain.repository.HabitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitDatabase(@ApplicationContext context: Context):HabitDatabase{
        return Room.databaseBuilder(
            context,
            HabitDatabase::class.java,
            "habit_db"
        ).build()
    }

    @Provides
    fun provideHabitDao(db:HabitDatabase)=db.habitDao()

    @Provides
    fun provideHabitRepository(dao: HabitDao):HabitRepository=HabitRepositoryImpl(dao)
}