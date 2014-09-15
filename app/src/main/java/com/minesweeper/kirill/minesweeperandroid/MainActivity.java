package com.minesweeper.kirill.minesweeperandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;
public class MainActivity extends Activity {
    private static final int GAME_ROWS = 8;
    private static final int GAME_COLUMNS = 8;
    private static final int GAME_MINES = 10;
    private static final String[] CELL_STATE_LABELS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "B"};
    private int[] mGameBoard;
    private int[] mVisibleBoard;
    private GridView mGameBoardGridView;
    private BaseAdapter mGameBoardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameBoard = generateRandomBoard(GAME_ROWS, GAME_COLUMNS, GAME_MINES);
        mVisibleBoard = new int[GAME_ROWS * GAME_COLUMNS];
        Arrays.fill(mVisibleBoard, -1);
        setContentView(R.layout.activity_main);
        mGameBoardGridView = (GridView) findViewById(R.id.gameboard_gridview);
        mGameBoardAdapter = new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null)
                    convertView = getLayoutInflater().inflate(R.layout.textview_cell, parent, false);
                TextView textView = (TextView) convertView;
                int visibleValue = mVisibleBoard[position];
                textView.setText(visibleValue < 0 ? " " : CELL_STATE_LABELS[visibleValue]);
                return textView;
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public Object getItem(int position) {
                return position;
            }
            @Override
            public int getCount() {
                return GAME_ROWS * GAME_COLUMNS;
            }
        };
        mGameBoardGridView.setAdapter(mGameBoardAdapter);
        mGameBoardGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mVisibleBoard[position] > 0)
                    return;
                int state = getCellState(mGameBoard, position);
                mVisibleBoard[position] = state;
                mGameBoardAdapter.notifyDataSetChanged();
            }
        });
        mGameBoardGridView.setNumColumns(GAME_COLUMNS);
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
}