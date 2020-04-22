package com.edchristy99.pertemuandb.Database;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataDiri.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public  abstract DataDiriDAO dao();
    private  static AppDatabase appDatabase;

    public static AppDatabase iniDB (Context context){
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,"datadiri_db").allowMainThreadQueries().build();
        return appDatabase;
    }
    public static void destroyInstance(){appDatabase=null;}
}
