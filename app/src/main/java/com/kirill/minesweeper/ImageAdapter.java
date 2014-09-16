package com.kirill.minesweeper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by kirill on 9/15/14.
 */
public class ImageAdapter extends BaseAdapter {



    @Override
    public int getCount() {
        return MainActivity.GAME_ROWS * MainActivity.GAME_COLUMNS;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(MainActivity.getAppContext());
        if (convertView == null) {
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(R.drawable.cell);
        return imageView;

    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        matrix = generateBoard(rows, columns, bombs);
//        printMatrix(matrix);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        final GridView fieldGridView = (GridView) findViewById(R.id.field_grid_view);
//        fieldGridView.setAdapter(new ImageCellAdapter(this));
//
//
//        fieldGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                openCell(view, position);
//            }
//        });
//
//        listenToRestartButton();
//    }

}
