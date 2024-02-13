package com.aac.barcos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NauticaEntity::class], version = 1, exportSchema = false)
abstract class NauticaDatabase : RoomDatabase() {
    abstract fun nauticaDao(): BarcosDao

/*
    abstract val dao: BarcosDao

    companion object {
        @Volatile
        private var INSTANCE: NauticaDatabase? = null

        fun getDatabase(context: Context): NauticaDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NauticaDatabase::class.java,
                        "barcos"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }

 */

}
