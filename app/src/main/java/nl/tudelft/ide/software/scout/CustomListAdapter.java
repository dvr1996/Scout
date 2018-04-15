package nl.tudelft.ide.software.scout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by davidvanrijn on 15/04/2018.
 */

public class CustomListAdapter extends ArrayAdapter<Place> {

    ArrayList<Place> places;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Place> places) {
        super(context, resource, places);
        this.places = places;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, null, true);

        }
        Place place = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.place_photo);
        Picasso.with(context).load(place.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.item_text);
        txtName.setText(place.getName());

//        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
//        txtPrice.setText(place.getLocationLong());
//
//        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
//        txtPrice.setText(place.getLocationLat());

        return convertView;
    }
}

//