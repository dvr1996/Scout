package nl.tudelft.ide.software.scout;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class DetailScreen extends AppCompatActivity {

    TextView itemtext;
    ImageView photo;
    Button find;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        itemtext = (TextView) findViewById(R.id.description);
        photo = (ImageView) findViewById(R.id.mainphoto);
        find = (Button) findViewById(R.id.findbutton);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
           itemtext.setText(String.valueOf(bundle.getInt("position")));
        }
    }

    public void find(View view) {
        Intent myIntent = new Intent(this,scoutScreen.class);
        startActivity(myIntent);
    }
}


