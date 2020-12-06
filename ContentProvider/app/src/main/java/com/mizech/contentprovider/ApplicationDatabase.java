package com.mizech.contentprovider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mizech.contentprovider.model.Dream;

@Database(entities = {Dream.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "dream_db";
    public static ApplicationDatabase INSTANCE;
    private Class<?> version;

    public static ApplicationDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    ApplicationDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }

    public abstract DreamDao getDreamDao();
}
