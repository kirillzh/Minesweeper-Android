package com.minesweeper.kirill.minesweeperandroid;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import static com.minesweeper.kirill.minesweeperandroid.Functionality.columns;
import static com.minesweeper.kirill.minesweeperandroid.ImageCellAdapter.getCoordinatesByPosition;


public class MainActivity extends Activity {

    GLSurfaceView mySurface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView fieldGridView = (GridView) findViewById(R.id.field_grid_view);
        fieldGridView.setAdapter(new ImageCellAdapter(this));

        fieldGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int x = getCoordinatesByPosition(position, columns)[0];
                int y = getCoordinatesByPosition(position, columns)[1];
                int value = ImageCellAdapter.matrix[x][y];

                ImageView imageView = (ImageView) view;

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
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
