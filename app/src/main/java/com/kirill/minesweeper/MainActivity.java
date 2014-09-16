package com.kirill.minesweeper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kirill on 9/15/14.
 */
public class MainActivity extends Activity {

    protected static final int GAME_ROWS = 8;
    protected static final int GAME_COLUMNS = 8;
    private static final int GAME_MINES = 10;
    private static final String[] CELL_STATE_LABELS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static int[] gameBoard;
    private int[] visibleGameBoard;
    private static Context context;
    private static GridView gameBoardGridView;
    private static BaseAdapter gameBoardAdapter;

    private static int[] drawableCells = new int[]{
            R.drawable.empty_cell,
            R.drawable.num1,
            R.drawable.num2,
            R.drawable.num3,
            R.drawable.num4,
            R.drawable.num5,
            R.drawable.num6,
            R.drawable.num7,
            R.drawable.num8,
            R.drawable.bomb
    };


    public static Context getAppContext() {
        return MainActivity.context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();

        gameBoard = generateRandomBoard(GAME_ROWS, GAME_COLUMNS, GAME_MINES);
        visibleGameBoard = new int[GAME_ROWS * GAME_COLUMNS];
        Arrays.fill(visibleGameBoard, -1);
        setContentView(R.layout.activity_main);
        gameBoardGridView = (GridView) findViewById(R.id.gameboard_gridview);
        gameBoardAdapter = new ImageAdapter();
        gameBoardGridView.setAdapter(gameBoardAdapter);
        gameBoardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (visibleGameBoard[position] > 0)
                    return;
                ImageView imageView = (ImageView) view;
                imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //             imageView.setImageResource(R.drawable.cell);
                int state = getCellState(gameBoard, position);
                setImageResource(imageView, state);

                //mVisibleBoard[position] = state;
                //mGameBoardAdapter.notifyDataSetChanged();
            }
        });
        gameBoardGridView.setNumColumns(GAME_COLUMNS);
    }


    public static int[] generateRandomBoard(int rows, int columns, int mines) {
        int size = rows * columns;
        int[] board = new int[size];
        Arrays.fill(board, 0);
        Random random = new Random();
        for (int i = 0; i < mines; i++)
            board[random.nextInt(size)] = 1;
        return board;
    }


    public static int getCellState(int[] board, int position) {
        if (board[position] == 1)
            return 9;
        int x = position / GAME_COLUMNS;
        int y = position % GAME_COLUMNS;
        int mines = 0;
        for (int row = x - 1; row < x + 2; row++) {
            if (row < 0 || row >= GAME_ROWS)
                continue;
            for (int col = y - 1; col < y + 2; col++) {
                if (col < 0 || col >= GAME_COLUMNS)
                    continue;
                if (board[(row * GAME_COLUMNS) + col] == 1)
                    mines++;
            }
        }
        return mines;
    }


    public static void setImageResource(ImageView imageView, int state) {
        if(state ==  9) {
            lostGame(gameBoardGridView);
            //imageView.setImageResource(drawableCells[state]);

        } else if(state == 0) {
            imageView.setImageResource(drawableCells[state]);
        } else {
            imageView.setImageResource(drawableCells[state]);
        }
    }


    public static void lostGame(GridView gridView) {
        Log.e("WARN", "You lost!");
        for(int position = 0; position < GAME_COLUMNS * GAME_ROWS; position++) {
            ImageView imageView = (ImageView) gridView.getChildAt(position);
            int state = getCellState(gameBoard, position);
            imageView.setImageResource(drawableCells[state]);
        }
    }


    public static void openEmptyCells() {

    }
}