package nl.tudelft.ide.software.scout;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class scoutScreen extends AppCompatActivity {

    public static double Long;
    public static double Lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "arial_black.ttf");
        Button myButton = findViewById(R.id.getHint);
        myButton.setTypeface(myTypeFace);

        int optie = 0;
        Long = 0;
        Lat = 0;

        Intent intent = getIntent();


        optie = intent.getIntExtra("position",0);

        if (optie == 0) {

            Long = 4.358817;
            Lat = 52.001314;

        } else if (optie == 1) {

            Long = 4.360082;
            Lat = 52.006372;

        } else if (optie == 2) {

            Long = 4.371162;
            Lat = 52.003243;

        } else if (optie == 3) {

            Long = 4.386121;
            Lat = 51.986761;
        }

        Log.i("Optie","long:"+Lat);

    }
}
