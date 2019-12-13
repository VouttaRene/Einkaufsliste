package de.voutta.einkaufsliste.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = ShoppingCartEntities.class, version = 1, exportSchema = false)
public abstract class ShoppingCartDatabase extends RoomDatabase {

    private static ShoppingCartDatabase instance;

    public abstract ShoppingCartDao shoppingCartDao();

    public static synchronized ShoppingCartDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ShoppingCartDatabase.class, "ShoppingCart_Databse")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private ShoppingCartDao shoppingCartDao;

        private PopulateDBAsyncTask(ShoppingCartDatabase db){
            shoppingCartDao = db.shoppingCartDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            shoppingCartDao.addToShoppingCart(new ShoppingCartEntities("Hähnchen", "400 g"));
            shoppingCartDao.addToShoppingCart(new ShoppingCartEntities("Sojamilch", "2 Stck"));
            shoppingCartDao.addToShoppingCart(new ShoppingCartEntities("Joghurt","2"));
            return null;
        }
    }
}
