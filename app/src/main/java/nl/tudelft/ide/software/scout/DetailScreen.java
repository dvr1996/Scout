package nl.tudelft.ide.software.scout;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailScreen extends AppCompatActivity {

    TextView itemtext;
    ImageView photo;
    Button find;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        itemtext = (TextView) findViewById(R.id.discription);
        photo = (ImageView) findViewById(R.id.mainphoto);
        find = (Button) findViewById(R.id.findbutton);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            itemtext.setText(bundle.getString("discription"));
            if (itemtext.getText().toString().equalsIgnoreCase("Delft")) {
                photo.setImageDrawable(ContextCompat.getDrawable(DetailScreen.this, R.drawable.delft));
            } else if (itemtext.getText().toString().equalsIgnoreCase("Nature")) {
                photo.setImageDrawable(ContextCompat.getDrawable(DetailScreen.this, R.drawable.nature_1));
            }

        }
    }
}
