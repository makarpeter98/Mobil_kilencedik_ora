package hu.unideb.inf.mobil2023.roomshoppinglist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoppinglistDAO {
    @Insert
    void insertListItem(ShoppingListItem sli);

    @Query("SELECT * FROM ShoppingList")
    List<ShoppingListItem> getAllItems();
}
