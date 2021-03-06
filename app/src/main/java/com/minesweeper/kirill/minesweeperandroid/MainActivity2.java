//package com.minesweeper.kirill.minesweeperandroid;
//
///**
//* Created by kirill on 9/14/14.
//*/
//
//import android.view.View;
//
//        import android.app.Activity;
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.view.Menu;
//        import android.view.View;
//        import android.widget.AdapterView;
//        import android.widget.Button;
//        import android.widget.GridView;
//        import android.widget.ImageView;
//
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.bombs;
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.columns;
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.generateBoard;
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.getCoordinatesByPosition;
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.printMatrix;
//        import static com.minesweeper.kirill.minesweeperandroid.Functionality.rows;
//
//
//public class MainActivity2 extends Activity {
//    static int[][] matrix;
//    static GridView fieldGridView;
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
//
//    public void listenToRestartButton() {
//        Button button = (Button) findViewById(R.id.restartButton);
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
//            }
//
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//
//    public static int getPositionByCoordinates(int x, int y) {
//        return (x * columns + y);
//    }
//
//
//
//
//    public static void openCell(View view, int position) {
//        int x = getCoordinatesByPosition(position, columns)[0];
//        int y = getCoordinatesByPosition(position, columns)[1];
//        int value = matrix[y][x];
//
//        ImageView imageView = (ImageView) view;
//        switch (value) {
//            case 0:
//                imageView.setImageResource(R.drawable.empty_cell);
//                break;
//            case 1:
//                imageView.setImageResource(R.drawable.num1);
//                break;
//            case 2:
//                imageView.setImageResource(R.drawable.num2);
//                break;
//            case 3:
//                imageView.setImageResource(R.drawable.num3);
//                break;
//            case 4:
//                imageView.setImageResource(R.drawable.num4);
//                break;
//            case 5:
//                imageView.setImageResource(R.drawable.num5);
//                break;
//            case 6:
//                imageView.setImageResource(R.drawable.num6);
//                break;
//            case 7:
//                imageView.setImageResource(R.drawable.num7);
//                break;
//            case 8:
//                imageView.setImageResource(R.drawable.num8);
//                break;
//            case 9:
//                imageView.setImageResource(R.drawable.bomb);
//                fieldGridView.setOnItemClickListener(null);
//                openAllCells(view, matrix);
//                break;
//        }
//    }
//
//
//    public static void openAllCells(View view, int[][] matrix) {
//        int positions = rows * columns;
//        for (int position = 0; position < positions; position++) {
//            int x = getCoordinatesByPosition(position, columns)[0];
//            int y = getCoordinatesByPosition(position, columns)[1];
//            int value = matrix[y][x];
//
//            ImageView imageView = (ImageView) view;
//            switch (value) {
//                case 0:
//                    imageView.setImageResource(R.drawable.empty_cell);
//                    break;
//                case 1:
//                    imageView.setImageResource(R.drawable.num1);
//                    break;
//                case 2:
//                    imageView.setImageResource(R.drawable.num2);
//                    break;
//                case 3:
//                    imageView.setImageResource(R.drawable.num3);
//                    break;
//                case 4:
//                    imageView.setImageResource(R.drawable.num4);
//                    break;
//                case 5:
//                    imageView.setImageResource(R.drawable.num5);
//                    break;
//                case 6:
//                    imageView.setImageResource(R.drawable.num6);
//                    break;
//                case 7:
//                    imageView.setImageResource(R.drawable.num7);
//                    break;
//                case 8:
//                    imageView.setImageResource(R.drawable.num8);
//                    break;
//                case 9:
//                    imageView.setImageResource(R.drawable.bomb);
//                    break;
//            }
//        }
//    }
//
//
//    // DON'T LOOK HERE
//    public static void openCellsAround(GridView fieldGridView, View view, int[][] matrix, int position) {
//        int x = getCoordinatesByPosition(position, columns)[0];
//        int y = getCoordinatesByPosition(position, columns)[1];
//        int value = matrix[y][x];
//
//        if(x == 0 && y == 0) {
//            openRightCell(view, position);
//            openBottomRightCell(view, position);
//            openBottomCell(view, position);
//        } else if(x > 0 && x < columns && y == 0) {
//            openRightCell(view, position);
//            openBottomRightCell(view, position);
//            openBottomCell(view, position);
//            openBottomLeftCell(view, position);
//            openLeftCell(view, position);
//        } else if(x == columns && y == 0) {
//            openBottomCell(view, position);
//            openBottomLeftCell(view, position);
//            openLeftCell(view, position);
//        } else if(x == columns && y > 0 && y < rows) {
//            openBottomCell(view, position);
//            openBottomLeftCell(view, position);
//            openLeftCell(view, position);
//            openTopLeftCell(view, position);
//            openTopCell(view, position);
//        } else if(x == columns && y == rows) {
//            openLeftCell(view, position);
//            openTopLeftCell(view, position);
//            openTopCell(view, position);
//        } else if(x > 0 && x < columns && y == rows) {
//            openLeftCell(view, position);
//            openTopLeftCell(view, position);
//            openTopCell(view, position);
//            openTopRightCell(view, position);
//            openRightCell(view, position);
//        } else if(x == 0 && y == rows) {
//            openTopCell(view, position);
//            openTopRightCell(view, position);
//            openRightCell(view, position);
//        } else if(x == 0 && y > 0 && y < rows) {
//            openTopCell(view, position);
//            openTopRightCell(view, position);
//            openRightCell(view, position);
//            openBottomRightCell(view, position);
//            openBottomCell(view, position);
//        } else if(x > 0 && x < columns && y > 0 && y < rows) {
//            openTopCell(view, position);
//            openTopRightCell(view, position);
//            openRightCell(view, position);
//            openBottomRightCell(view, position);
//            openBottomCell(view, position);
//            openBottomLeftCell(view, position);
//            openLeftCell(view, position);
//            openTopLeftCell(view, position);
//        }
//
//
//    }
//
//    public static void openTopCell(View view, int position) {
//        openCell(view, position - columns);
//    }
//
//    public static void openTopRightCell(View view, int position) {
//        openCell(view, position - columns + 1);
//    }
//
//    public static void openRightCell(View view, int position) {
//        openCell(view, position + 1);
//    }
//
//    public static void openBottomRightCell(View view, int position) {
//        openCell(view, position + columns + 1);
//    }
//
//    public static void openBottomCell(View view, int position) {
//        openCell(view, position + columns);
//    }
//
//    public static void openBottomLeftCell(View view, int position) {
//        openCell(view, position + columns - 1);
//    }
//
//    public static void openLeftCell(View view, int position) {
//        openCell(view, position - 1);
//    }
//
//    public static void openTopLeftCell(View view, int position) {
//        openCell(view, position - columns - 1);
//    }
//
//}
