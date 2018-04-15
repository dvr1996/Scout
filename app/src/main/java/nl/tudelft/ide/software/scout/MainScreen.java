package nl.tudelft.ide.software.scout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;



/*
The only difference here is we are going to use a our Custom adapter instead of an Array Adapter.
We pass the foods array as part of the constructor.
Note: we don't have an array of images so we use the same one every time,
else we would modify CustomAdapter to accept that array too.
 */


public class MainScreen extends AppCompatActivity {



    ArrayList<Place> arrayList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.custom_ListView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://192.168.2.136:8081/loadpictures");
            }
        });



        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                        Intent intent = new Intent(MainScreen.this, scoutScreen.class);
                        intent.putExtra("position",i);
                        startActivity(intent);
                    }
                }
        );
    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray =  jsonObject.getJSONArray("Picturesss");

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject placeObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Place(
                            placeObject.getString("image"),
                            placeObject.getString("name"),
                            placeObject.getString("LocationLong"),
                            placeObject.getString("LocationLat")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomListAdapter adapter = new CustomListAdapter(
                    getApplicationContext(), R.layout.custom_row, arrayList
            );
            lv.setAdapter(adapter);
        }
    }


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


}
//
