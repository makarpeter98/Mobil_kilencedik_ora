package hu.unideb.inf.mobil2023.roomshoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShoppingListDataBase shoppingListDataBase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoppingListDataBase = Room.databaseBuilder(this,
                        ShoppingListDataBase.class,
                        "shoppingList_db")
                .fallbackToDestructiveMigration()
                .build();

        new Thread(
                () -> Log.i("checkDb", shoppingListDataBase.shoppinglistDAO().getAllItems().toString())
        ).start();
        newItemEditText = findViewById(R.id.newItemEditText);
        itemsListTextView = findViewById(R.id.itemsListTextView);

        refreshUI();
    }

    EditText newItemEditText;
    TextView itemsListTextView;

    public void addNewItem(View view) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                ShoppingListItem sli = new ShoppingListItem();
                sli.setName(newItemEditText.getText().toString());
                shoppingListDataBase.shoppinglistDAO().insertListItem(sli);
                refreshUI();
                return null;
            }
        }.execute();
    }

    private void refreshUI() {
        new Thread(
                () -> {
                    String str = shoppingListDataBase.shoppinglistDAO().getAllItems().toString();
                    runOnUiThread(
                            () -> itemsListTextView.setText(str)
                    );
                }
        ).start();
    }
}