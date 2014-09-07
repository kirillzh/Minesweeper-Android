package com.minesweeper.kirill.minesweeperandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView fieldGridView = (GridView) findViewById(R.id.field_grid_view);
        fieldGridView.setAdapter(new ImageCellAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
