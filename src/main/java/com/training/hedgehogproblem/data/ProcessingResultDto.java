package com.training.hedgehogproblem.data;

public class ProcessingResultDto {
    private final int[][] array;
    private final int[][] walkArray;
    private int walkResult;

    public ProcessingResultDto(int[][] array, int[][] walkArray, int walkResult) {
        this.array = array;
        this.walkArray = walkArray;
        this.walkResult = walkResult;
    }

    public int[][] getArray() {
        return array;
    }

    public int[][] getWalkArray() {
        return walkArray;
    }

    public int getWalkResult() {
        return walkResult;
    }
}
