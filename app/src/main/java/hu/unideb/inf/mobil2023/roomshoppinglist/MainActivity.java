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

    EditText newItemEditText;
    TextView itemsListTextView;
    private ShoppingListDataBase shoppingListDataBase = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewItem(View view) {

    }

    private void refreshUI() {

    }
}