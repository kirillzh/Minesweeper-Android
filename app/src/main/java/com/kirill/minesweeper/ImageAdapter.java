package com.kirill.minesweeper;

import android.widget.BaseAdapter;
import android.widget.GridView;

import com.minesweeper.kirill.minesweeperandroid.R;

/**
 * Created by kirill on 9/15/14.
 */
public class ImageAdapter {

    private static GridView gameBoardGridView;
    private static BaseAdapter gameBoardAdapter;
    private static int[] cellImages = new int[]{
            R.drawable.empty_cell,
            R.drawable.num1,
            R.drawable.num2,
            R.drawable.num3,
            R.drawable.num4,
            R.drawable.num5,
            R.drawable.num6,
            R.drawable.num7,
            R.drawable.num8,
            R.drawable.bomb};

}
