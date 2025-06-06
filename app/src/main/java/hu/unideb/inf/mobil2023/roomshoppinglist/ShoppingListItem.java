package hu.unideb.inf.mobil2023.roomshoppinglist;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ShoppingList")
public class ShoppingListItem {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;

    @Override
    public String toString() {
        return id + " - " + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
