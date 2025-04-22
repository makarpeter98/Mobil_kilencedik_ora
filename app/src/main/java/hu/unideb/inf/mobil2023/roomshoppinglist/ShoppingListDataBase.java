package hu.unideb.inf.mobil2023.roomshoppinglist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ShoppingListItem.class}, version = 2, exportSchema = false)
public abstract class ShoppingListDataBase extends RoomDatabase {
    public abstract ShoppinglistDAO shoppinglistDAO();
}
