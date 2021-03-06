package com.jaiberyepes.breakingbadchallenge.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jaiberyepes.breakingbadchallenge.data.cache.database.dao.CharactersDao
import com.jaiberyepes.breakingbadchallenge.data.cache.database.entities.CharacterEntity

/**
 * Database class for Characters related Dao.
 *
 * @author jaiber.yepes
 */
@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}
