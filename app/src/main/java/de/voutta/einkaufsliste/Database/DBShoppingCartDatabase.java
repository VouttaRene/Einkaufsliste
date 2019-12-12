package de.voutta.einkaufsliste.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DBShoppingCart.class}, version = 1, exportSchema = false)
public abstract class DBShoppingCartDatabase extends RoomDatabase {

    public abstract DBShoppingCartDao dbShoppingCartDao();
}
