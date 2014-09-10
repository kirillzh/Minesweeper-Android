package com.minesweeper.kirill.minesweeperandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static com.minesweeper.kirill.minesweeperandroid.Functionality.columns;
import static com.minesweeper.kirill.minesweeperandroid.Functionality.generateBoard;

/**
 * Created by kirill on 9/7/14.
 */
public class ImageCellAdapter extends BaseAdapter {
    public Context mContext;
    public int[][] matrix;

    // Constructor
    public ImageCellAdapter(Context c) {
        matrix = generateBoard(8, 8, 10);
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

        int x = getCoordinatesByPosition(position, columns)[0];
        int y = getCoordinatesByPosition(position, columns)[1];

        int value = matrix[x][y];

        switch (value) {
            case 0:
                imageView.setImageResource(R.drawable.cell);
            case 1:
                imageView.setImageResource(R.drawable.num1);
            case 2:
                imageView.setImageResource(R.drawable.num2);
            case 3:
                imageView.setImageResource(R.drawable.num3);
            case 4:
                imageView.setImageResource(R.drawable.num4);
            case 5:
                imageView.setImageResource(R.drawable.num5);
            case 6:
                imageView.setImageResource(R.drawable.num6);
            case 7:
                imageView.setImageResource(R.drawable.num7);
            case 8:
                imageView.setImageResource(R.drawable.num8);
            case 9:
                imageView.setImageResource(R.drawable.bomb);
        }
        return imageView;
    }

    public static int getPositionByCoordinates(int x, int y, int columns) {
        return (x * columns + y);
    }

    public static int[] getCoordinatesByPosition(int position, int columns) {
        return new int[]{position / columns, position % columns};
    }

}