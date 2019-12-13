package de.voutta.einkaufsliste.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ShoppingCartEntities.class, version = 1, exportSchema = false)
public abstract class ShoppingCartDatabase extends RoomDatabase {

    private static ShoppingCartDatabase instance;

    public abstract ShoppingCartDao shoppingCartDao();

    public static synchronized ShoppingCartDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ShoppingCartDatabase.class, "ShoppingCart_Databse")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
