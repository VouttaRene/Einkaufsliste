package de.voutta.einkaufsliste.Database;


import android.support.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class DBShoppingCart {

    //Constructor
    public DBShoppingCart(@NonNull String toBuy, String quantity) {
        this.toBuy = toBuy;
        this.quantity = quantity;
    }

    //Columns
    @ColumnInfo(name = "ToBuy")
    @NonNull private String toBuy;

    @ColumnInfo(name = "Quantity")
    private String quantity;

    @NonNull
    public String getToBuy() {
        return toBuy;
    }

    //Getter and Setter
    public void setToBuy(@NonNull String toBuy) {
        this.toBuy = toBuy;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
