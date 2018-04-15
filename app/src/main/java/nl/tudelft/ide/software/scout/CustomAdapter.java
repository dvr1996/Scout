package nl.tudelft.ide.software.scout;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row, parent, false);
        // get references.
        String places= getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.item_text);
        ImageView photo = (ImageView) customView.findViewById(R.id.place_photo);
        //Button find = (Button) customView.findViewById(R.id.find_button);

//        itemText.setVisibility(View.GONE);
//        find.setVisibility(View.GONE);

        // dynamically update the text from the array
        itemText.setText(places);
        // set discription invisible
        itemText.setVisibility(View.GONE);
        // using the same image every time
        switch(position) {
            case 0:
                photo.setImageResource(R.drawable.delft);
                break;
            case 1:
                photo.setImageResource(R.drawable.nature_1);
                break;
            case 2:
                photo.setImageResource(R.drawable.delft);
                break;
            case 3:
                photo.setImageResource(R.drawable.nature_1);
                break;
            case 4:
                photo.setImageResource(R.drawable.delft);
                break;
            case 5:
                photo.setImageResource(R.drawable.nature_1);
                break;


        }
        // Now we can finally return our custom View or custom item
        return customView;
    }

}
