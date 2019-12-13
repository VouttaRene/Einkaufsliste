package de.voutta.einkaufsliste.Database;

import android.arch.lifecycle.LiveData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ShoppingCartDao {

    @Insert
    void addToShoppingCart(ShoppingCartEntities shoppingCartEntities);

    @Update
    void updateShoppingCart(ShoppingCartEntities shoppingCartEntities);

    @Delete
    void deleteFromShoppingCart(ShoppingCartEntities shoppingCartEntities);

    @Query("DELETE FROM ShoppingCart")
    void deleteAllFromShoppingCart();

    @Query("SELECT * FROM ShoppingCart ORDER BY Id ASC")
    LiveData<List<ShoppingCartEntities>> getEverythingFromShoppingCart();

}
