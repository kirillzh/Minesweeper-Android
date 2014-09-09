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

    // Constructor
    public ImageCellAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return Functionality.rows * Functionality.columns;
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
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(R.drawable.cell);
        return imageView;
    }

}