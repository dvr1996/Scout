package nl.tudelft.ide.software.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



/*
The only difference here is we are going to use a our Custom adapter instead of an Array Adapter.
We pass the foods array as part of the constructor.
Note: we don't have an array of images so we use the same one every time,
else we would modify CustomAdapter to accept that array too.
 */


public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        final String[] places = new String[]{"Delft", "Nature", "Streetart", "Delft", "Nature", "Streetart"};
        // Replace the Array adapter with your custom adapter.
        ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);
        final ListAdapter customListAdapter = new CustomAdapter(this, places);// Pass the food arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.custom_ListView);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainScreen.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void find(View view) {
        Intent myIntent = new Intent(this,HomeScreen.class);
        startActivity(myIntent);
    }


}

