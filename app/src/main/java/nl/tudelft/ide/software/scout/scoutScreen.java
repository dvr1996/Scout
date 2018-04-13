package nl.tudelft.ide.software.scout;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class scoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);
        Typeface myTypeFace= Typeface.createFromAsset(getAssets(),"arial_black.ttf");
        Button myButton = findViewById(R.id.getHint);
        myButton.setTypeface(myTypeFace);
    }
}
