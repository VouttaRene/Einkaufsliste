package de.voutta.einkaufsliste.Database;

import android.support.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ShoppingCart")
public class ShoppingCartEntities {


    //Constructor
    public ShoppingCartEntities(String scToBuy, String scQuantity) {
        this.scToBuy = scToBuy;
        this.scQuantity = scQuantity;
    }

    //Entities
    @ColumnInfo(name = "Id")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int scId;

    @ColumnInfo(name = "To_Buy")
    private String scToBuy;

    @ColumnInfo(name = "Quantity")
    private String scQuantity;


    //Getter and Setter
    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    public String getScToBuy() {
        return scToBuy;
    }

    public String getScQuantity() {
        return scQuantity;
    }

}
