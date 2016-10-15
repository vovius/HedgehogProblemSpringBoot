package com.training.hedgehogproblem.util;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class HedgehogWalkHelper {

    public static void printArray(int[][] array, String header) {
        if (array != null) {
            System.out.println(header);
            for (int i = 0; i < array.length; i++) {
                System.out.println(Arrays.toString(array[i]));
            }
        }
    }

    public static void randomizeArray(int[][] array) {
        if (array != null) {
            Random random = new Random();
            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array[i].length; j++)
                    array[i][j] = random.nextInt(9);
        }
    }

    public static int[][] createArrayWithRandomData(int sizeI, int sizeJ) {
        int[][] array = new int[sizeI][sizeJ];
        randomizeArray(array);
        return array;
    }

    public static int[][] parseToArrayFromFile(String fileName) throws FileNotFoundException {
        InputStream stream = new FileInputStream(fileName);
        return createArrayFromFileStream(stream);
    }

    public static int[][] createArrayFromFileStream(InputStream file) {
        InputStreamReader inputStreamReader = new InputStreamReader(file);
        int[][] array = null;
        try (BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line = br.readLine();
            if (line != null) {
                // first line should contain the sizes of the matrix
                String[] fieldSize = line.split(" ");
                if (fieldSize != null && fieldSize.length == 2)
                    array = new int[Integer.valueOf(fieldSize[0])][Integer.valueOf(fieldSize[1])];
            }

            if (array != null) {
                int i=0;
                while ((line = br.readLine()) != null) {
                    String[] cells = line.trim().split(" ");
                    if (cells != null) {
                        for (int j = 0; j < cells.length; j++) {
                            array[i][j] = Integer.valueOf(cells[j]);
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Array loading from file has failed!");
            e.printStackTrace();
            return null;
        }

        return array;
    }

    public static void writeResultOfWalking(int[][] array, String fileName) {
        int result = array[array.length-1][array[0].length-1];
        try (PrintWriter writer = new PrintWriter((fileName))) {
            writer.print(result);
        } catch (IOException e) {
            System.err.println("Failed to write the result to file!");
            e.printStackTrace();
        }
    }

}
