package com.minesweeper.kirill.minesweeperandroid;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kirill on 9/8/14.
 */
public class Functionality {

    public static int columns = 8, rows = 8, bombs = 10;
    private static int EMPTY_CELL_VALUE = 0, BOMB_VALUE = 9;


    public static void main(String[] args) {
        int[][] matrix = generateBoard(rows, columns, bombs);
        //placeNumbers(matrix);
        printMatrix(matrix);
    }

    public static int[][] generateBoard(int rows, int columns, int bombs) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for(int bombCounter = 0; bombCounter < bombs; ) {
            int randomX = random.nextInt(columns), randomY = random.nextInt(rows);
            if(matrix[randomX][randomY] != BOMB_VALUE) {
                matrix[randomX][randomY] = BOMB_VALUE;
                //setCellValue(matrix, randomX, randomY, BOMB_VALUE);
                bombCounter++;
            }
        }
        placeNumbers(matrix, rows, columns);
        return matrix;
    }



//    public static void setCellValue(int[][] matrix, int x, int y, int value) {
//        matrix[x][y] = value;
//    }

    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void placeNumbers(int[][] matrix, int rows, int columns) {
        for(int x = 0; x < columns; x++) {
            for(int y = 0; y < rows; y++) {
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 );
                if(matrix[x][y] != BOMB_VALUE)
                    matrix[x][y] = checkCell(matrix, x, y, rows, columns);
            }
        }
    }

//    private static int checkCenter(int[][] matrix, int x, int y) {
//        return (matrix[x][y] == BOMB_VALUE) ? 1 : 0;
//    }

    private static int checkTop(int[][] matrix, int x, int y) {
        return (matrix[x][y-1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkTopRight(int[][] matrix, int x, int y) {
        return (matrix[x+1][y-1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkRight(int[][] matrix, int x, int y) {
        return (matrix[x+1][y] == BOMB_VALUE) ? 1 : 0;
    }
    private static int checkBottomRight(int[][] matrix, int x, int y) {
        return (matrix[x+1][y+1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkBottom(int[][] matrix, int x, int y) {
        return (matrix[x][y+1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkBottomLeft(int[][] matrix, int x, int y) {
        return (matrix[x-1][y+1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkLeft(int[][] matrix, int x, int y) {
        return (matrix[x-1][y] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkTopLeft(int[][] matrix, int x, int y) {
        return (matrix[x-1][y-1] == BOMB_VALUE) ? 1 : 0;
    }

    private static int checkCell(int[][] matrix, int x, int y, int rows, int columns) {
        rows--;
        columns--;
        if(x == 0 && y == 0)
            return (checkRight(matrix, x, y) + checkBottomRight(matrix, x, y) + checkBottom(matrix, x, y));
        else if(x > 0 && x < columns && y == 0)
            return (checkRight(matrix, x, y) + checkBottomRight(matrix, x, y) + checkBottom(matrix, x, y) + checkBottomLeft(matrix, x, y) + checkLeft(matrix, x, y));
        else if(x == columns && y == 0)
            return (checkBottom(matrix, x, y) + checkBottomLeft(matrix, x, y) + checkLeft(matrix, x, y));
        else if(x == columns && y > 0 && y < rows)
            return (checkBottom(matrix, x, y) + checkBottomLeft(matrix, x, y) + checkLeft(matrix, x, y) + checkTopLeft(matrix, x, y) + checkTop(matrix, x, y));
        else if(x == columns && y == rows)
            return (checkLeft(matrix, x, y) + checkTopLeft(matrix, x, y) + checkTop(matrix, x, y));
        else if(x > 0 && x < columns && y == rows)
            return (checkLeft(matrix, x, y) + checkTopLeft(matrix, x, y) + checkTop(matrix, x, y) + checkTopRight(matrix, x, y) + checkRight(matrix, x, y));
        else if(x == 0 && y == rows)
            return (checkTop(matrix, x, y) + checkTopRight(matrix, x, y) + checkRight(matrix, x, y));
        else if(x == 0 && y > 0 && y < rows)
            return (checkTop(matrix, x, y) + checkTopRight(matrix, x, y) + checkRight(matrix, x, y) + checkBottomRight(matrix, x, y) + checkBottom(matrix, x, y));
        else if(x > 0 && x < columns && y > 0 && y < rows)
            return (checkTop(matrix, x, y) + checkTopRight(matrix, x, y) + checkRight(matrix, x, y) + checkBottomRight(matrix, x, y) + checkBottom(matrix, x, y) + checkBottomLeft(matrix, x, y) + checkLeft(matrix, x, y) + checkTopLeft(matrix, x, y));
        else
            return EMPTY_CELL_VALUE;
    }

}


