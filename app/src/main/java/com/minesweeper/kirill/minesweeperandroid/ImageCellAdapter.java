package com.minesweeper.kirill.minesweeperandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by kirill on 9/7/14.
 */
public class ImageCellAdapter extends BaseAdapter {
    private Context mContext;
    public ImageCellAdapter(MainActivity mainActivity) {

    }

    // Constructor
    public ImageCellAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        //fillArray(mThumbIds, R.drawable.cell, 4);
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(R.drawable.cell);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {

    };

    private void fillArray(Integer[] array, Integer value, int amount) {
        for(int counter = 0; counter < amount; counter++) {
            array[counter] = value;
        }
    }
}