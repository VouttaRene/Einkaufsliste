package de.voutta.einkaufsliste.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.List;

public class ShoppingCartRepository {

    private ShoppingCartDao shoppingCartDao;
    private LiveData<List<ShoppingCartEntities>> everythingFromShoppingCart;

    public ShoppingCartRepository(Application application){
        ShoppingCartDatabase database = ShoppingCartDatabase.getInstance(application);
        shoppingCartDao = database.shoppingCartDao();
        everythingFromShoppingCart = shoppingCartDao.getEverythingFromShoppingCart();

    }

    public void insert(ShoppingCartEntities shoppingCartEntities){
        new InsertShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCartEntities);
    }

    public void update(ShoppingCartEntities shoppingCartEntities){
        new UpdateShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCartEntities);
    }

    public void delete(ShoppingCartEntities shoppingCartEntities){
        new DeleteShoppingCartAsyncTask(shoppingCartDao).execute(shoppingCartEntities);
    }

    public void deleteAll(){
        new DeleteEverythingShoppingCartAsyncTask(shoppingCartDao).execute();
    }

    public LiveData<List<ShoppingCartEntities>> getEverythingFromShoppingCart(){
        return everythingFromShoppingCart;
    }

    //AsyncTasks

    //Insert
    private static class InsertShoppingCartAsyncTask extends AsyncTask<ShoppingCartEntities, Void, Void> {
        private ShoppingCartDao shoppingCartDao;

        private InsertShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao) {
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCartEntities... shoppingCartEntities) {
            shoppingCartDao.addToShoppingCart(shoppingCartEntities[0]);
            return null;
        }
    }

    //Update
    private static class UpdateShoppingCartAsyncTask extends AsyncTask<ShoppingCartEntities, Void, Void> {
        private ShoppingCartDao shoppingCartDao;

        private UpdateShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao) {
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCartEntities... shoppingCartEntities) {
            shoppingCartDao.updateShoppingCart(shoppingCartEntities[0]);
            return null;
        }
    }

    //Delete
    private static class DeleteShoppingCartAsyncTask extends AsyncTask<ShoppingCartEntities, Void, Void> {
        private ShoppingCartDao shoppingCartDao;

        private DeleteShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao) {
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(ShoppingCartEntities... shoppingCartEntities) {
            shoppingCartDao.deleteFromShoppingCart(shoppingCartEntities[0]);
            return null;
        }
    }

    //Delete everything from Shopping Cart
    private static class DeleteEverythingShoppingCartAsyncTask extends AsyncTask<Void, Void, Void> {
        private ShoppingCartDao shoppingCartDao;

        private DeleteEverythingShoppingCartAsyncTask(ShoppingCartDao shoppingCartDao) {
            this.shoppingCartDao = shoppingCartDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            shoppingCartDao.deleteAllFromShoppingCart();
            return null;
        }
    }

}
