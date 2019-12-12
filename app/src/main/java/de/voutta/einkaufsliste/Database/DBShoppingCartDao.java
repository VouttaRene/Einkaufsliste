package de.voutta.einkaufsliste.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface DBShoppingCartDao {

    @Insert
    public void addToBuy(DBShoppingCart... dbShoppingCarts);

    @Delete
    public void deleteToBuy(DBShoppingCart... dbShoppingCarts);

}
