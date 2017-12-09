package com.doof.aoc;

public class AoCManhattan {

    public static void main(String[] args) {

        // Set the target value here
        int target = 368078;

        // Find the odd square that will always be the highest diagonal value
        double root = Math.sqrt(target);
        int ceil = (int)Math.ceil(root);

        if (ceil % 2 == 0) {
            ceil++;
        }

        // The 4 diagonals can be found using the odd ceiling value and the even value below it
        int[] squares = new int[]{ceil - 1, ceil};
        int[] diagonals = new int[4];

        // Generate an ordered array with the 4 outermost diagonals of the matrix
        for (int square : squares) {
            if (square % 2 == 1) {
                diagonals[0] = square * square - square + 1;
                diagonals[1] = square * square;
            } else {
                diagonals[2] = square * square - square + 1;
                diagonals[3] = square * square + 1;
            }
        }

        // Find the diagonal that's closest to the target
        // Trying to find numbers closest to the max diagonal sucks
        // For example, 10 is only 1 spot away from 25, but that's a pain to calculate
        // So here we set the default value by using the diagonal below max, i.e. 9 instead of 25
        int closestDistance = target - (ceil - 2) * (ceil - 2);

        // Check and see if one of the other diagonals is closer than the assumed numbers above
        for (int diagonal : diagonals) {
            if (Math.abs(diagonal - target) < closestDistance) {
                closestDistance = Math.abs(diagonal - target);
            }
        }

        // Calculate the final manhattan distance
        int manhattan = ceil - 1 - closestDistance;
        System.out.println("Manhattan: " + manhattan);
    }
}
