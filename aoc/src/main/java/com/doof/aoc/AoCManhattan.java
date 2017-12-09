package com.doof.aoc;

import com.doof.utils.Util;

import java.util.*;
import java.awt.Point;

public class AoCManhattan {

    private static final int MAX = 10;
    private static final int TARGET = 46;

    public static void main(String[] args) {
        // Generate a map with the 4 diagonals of the matrix and their coordinates
        Map<Integer, Point> diagonals = new HashMap<>();

        for (int i = 2; i <= MAX; i++) {
            if (i % 2 == 0) {
                diagonals.put(i * i - i, new Point(i/2, i/2));
                diagonals.put(i * i, new Point(i/2, -(i/2)));
            }
            else {
                diagonals.put(i * i - i, new Point(-((i-1)/2), -((i-1)/2)));
                diagonals.put(i * i - 1, new Point(-((i-1)/2), (i-1)/2));
            }

        }

        // Get a sorted list of the diagonals of the matrix
        Collection<Integer> unsorted = diagonals.keySet();
        List<Integer> sorted = Util.asSortedList(unsorted);

//        for (int i = 0; i < sorted.size(); i++) {
//            System.out.println(sorted.get(i) + ": (" + diagonals.get(sorted.get(i)).x + ", " + diagonals.get(sorted.get(i)).y + ")");
//        }

        // Find the closest diagonal and the distance to it
        int dist = MAX;
        int closestDiagonal = 0;
        for (Integer num : diagonals.keySet()) {
            if (Math.abs(TARGET - num) < Math.abs(dist)) {
                dist = TARGET - num;
                closestDiagonal = num;
            }
        }

        System.out.println("Diagonal: " + closestDiagonal);
        System.out.println("Distance: " + dist);
    }
}
