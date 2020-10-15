package com.example.android.miwok;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private  int mColorResID ;

    public WordAdapter(Activity context, ArrayList<Word> words , int R) {
        super(context, 0, words);
        mColorResID = R ;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.text_view1);

        miwokTextView.setText(currentWord.getmMiwokTranslation());
        miwokTextView.setBackgroundColor(mColorResID);

        TextView engTextView = (TextView) listItemView.findViewById(R.id.text_view2);

        engTextView.setText(currentWord.getmEnglishTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.isImg()) {

            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }

}
