package com.doof.aoc;

import java.util.HashMap;
import java.util.Map;

public class AoCManhattan {

    public static void main(String[] args) {

        // Set the target value here
        int target = 368078;
        Map<Integer, Integer> diagonals = new HashMap<>();

        // Find the odd square that will always be the highest diagonal value
        double root = Math.sqrt(target);
        int ceil = (int)Math.ceil(root);

        if (ceil % 2 == 0) {
            ceil++;
        }

        // The 4 diagonals can be found using the odd ceiling value and the even value below it
        int[] squares = new int[]{ceil - 1, ceil};

        // Generate a map with the 4 outermost diagonals of the matrix and their Manhattan distance
        for (int i = 0; i < squares.length; i++) {

            if (squares[i] % 2 == 1) {
                diagonals.put(squares[i] * squares[i] - squares[i] + 1, squares[i]-1);
                diagonals.put(squares[i] * squares[i], squares[i]-1);
            } else {
                diagonals.put(squares[i] * squares[i] - squares[i] + 1, squares[i]);
                diagonals.put(squares[i] * squares[i] + 1, squares[i]);
            }
        }

        // Find the diagonal that's closest to the target
        // Trying to find numbers closest to the max diagonal sucks
        // For example, 10 is only 1 spot away from 25, but that's a pain to calculate
        // So here we set the default values by using the diagonal below max, i.e. 9 instead of 25
        int closestDiagonal = ceil * ceil;
        int closestDistance = target - (ceil - 2) * (ceil - 2);

        // Check and see if one of the other diagonals is closer than the assumed numbers above
        for (int key : diagonals.keySet()) {
            if (closestDistance == -1) {
                closestDiagonal = key;
                closestDistance = Math.abs(key - target);
            } else {
                if (Math.abs(key - target) < closestDistance) {
                    closestDiagonal = key;
                    closestDistance = Math.abs(key - target);
                }
            }
        }

        // Calculate the final manhattan distance
        int manhattan = diagonals.get(closestDiagonal) - closestDistance;
        System.out.println("Manhattan: " + manhattan);
    }
}
