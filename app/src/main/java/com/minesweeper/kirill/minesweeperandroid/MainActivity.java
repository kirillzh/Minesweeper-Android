package com.minesweeper.kirill.minesweeperandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import static com.minesweeper.kirill.minesweeperandroid.Functionality.bombs;
import static com.minesweeper.kirill.minesweeperandroid.Functionality.columns;
import static com.minesweeper.kirill.minesweeperandroid.Functionality.generateBoard;
import static com.minesweeper.kirill.minesweeperandroid.Functionality.printMatrix;
import static com.minesweeper.kirill.minesweeperandroid.Functionality.rows;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[][] matrix = generateBoard(rows, columns, bombs);
        printMatrix(matrix);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView fieldGridView = (GridView) findViewById(R.id.field_grid_view);
        fieldGridView.setAdapter(new ImageCellAdapter(this));


        fieldGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                openCell(fieldGridView, view, matrix, position);
            }
        });

        listenToRestartButton();
    }

    public void listenToRestartButton() {
        Button button = (Button) findViewById(R.id.restartButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


//    public static int getPositionByCoordinates(int x, int y, int columns) {
//        return (x * columns + y);
//    }


    public static int[] getCoordinatesByPosition(int position, int columns) {
        return new int[]{position % columns, position / columns};
    }


    public void openCell(GridView fieldGridView, View view, int[][] matrix, int position) {
        int x = getCoordinatesByPosition(position, columns)[0];
        int y = getCoordinatesByPosition(position, columns)[1];
        int value = matrix[y][x];

        ImageView imageView = (ImageView) view;
        switch (value) {
            case 0:
                imageView.setImageResource(R.drawable.empty_cell);
                break;
            case 1:
                imageView.setImageResource(R.drawable.num1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.num2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.num3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.num4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.num5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.num6);
                break;
            case 7:
                imageView.setImageResource(R.drawable.num7);
                break;
            case 8:
                imageView.setImageResource(R.drawable.num8);
                break;
            case 9:
                imageView.setImageResource(R.drawable.bomb);
                fieldGridView.setOnItemClickListener(null);
                openAllCells(view, matrix);
                break;
        }
    }


    public void openAllCells(View view, int[][] matrix) {
        int positions = rows * columns;
        for (int position = 0; position < positions; position++) {
            int x = getCoordinatesByPosition(position, columns)[0];
            int y = getCoordinatesByPosition(position, columns)[1];
            int value = matrix[y][x];

            ImageView imageView = (ImageView) view;
            switch (value) {
                case 0:
                    imageView.setImageResource(R.drawable.empty_cell);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.num1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.num2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.num3);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.num4);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.num5);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.num6);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.num7);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.num8);
                    break;
                case 9:
                    imageView.setImageResource(R.drawable.bomb);
                    break;
            }
        }
    }

    int topLeftCorener = 0;
    int topRightCorner = columns - 1;
    int bottomLeftCorner = 0;

    public static void openEmptyCells(View view, int[][] matrix, int position) {

    }
}
