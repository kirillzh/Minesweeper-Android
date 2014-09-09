package com.minesweeper.kirill.minesweeperandroid;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kirill on 9/8/14.
 */
public class Functionality {

    private static int columns = 8;
    private static int rows = 8;
    private static int EMPTY_CELL_VALUE = 0, BOMB_VALUE = 9;



    public static void main(String[] args) {
        int[][] matrix = createEmptyMatrix(rows, columns);
        placeRandomBombs(matrix);
        printMatrix(matrix);
    }

    public static int[][] createEmptyMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for(int x = 0; x < matrix[0].length; x++) {
            for(int y = 0; y < matrix.length; y++) {
                matrix[x][y] = EMPTY_CELL_VALUE;
            }
        }
        return matrix;
    }

    public static void placeRandomBombs(int[][] matrix) {
        Random random = new Random();

        int bombs = 10;
        for(int bombCounter = 0; bombCounter < bombs; ) {
            int randomX = random.nextInt(columns);
            int randomY = random.nextInt(rows);
            if(matrix[randomX][randomY] == EMPTY_CELL_VALUE) {
                setCellValue(matrix, randomX, randomY, BOMB_VALUE);
                bombCounter++;
            }
        }
    }

    public static void setCellValue(int[][] matrix, int x, int y, int value) {
        matrix[x][y] = value;
    }

    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void placeNumbers(int[][] matrix) {

    }


    private static boolean checkCell(int[][] matrix, int x, int y) {
        return matrix[x][y] == BOMB_VALUE;
    }

    private static boolean checkTop(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkTopRight(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkRight(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }
    private static boolean checkBootomRight(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkBottom(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkBottomLeft(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkLeft(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }

    private static boolean checkTopLeft(int[][] matrix, int x, int y) {
        return matrix[x-1][y] == BOMB_VALUE;
    }



}
