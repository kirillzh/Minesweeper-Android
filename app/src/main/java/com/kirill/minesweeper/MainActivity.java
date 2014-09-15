package com.kirill.minesweeper;

import android.app.Activity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kirill on 9/15/14.
 */
public class MainActivity extends Activity {

    private static final int GAME_ROWS = 8;
    private static final int GAME_COLUMNS = 8;
    private static final int GAME_MINES = 10;
    private static final String[] CELL_STATE_LABELS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static int[] gameBoard;
    private int[] visibleGameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameBoard = generateRandomBoard(GAME_ROWS, GAME_COLUMNS, GAME_MINES);


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
