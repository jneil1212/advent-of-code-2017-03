package com.doof.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util {

    // Calculate the nearest square number
    public static double nearestSquare (int num) {
        double root = Math.sqrt(num);
        double floor = Math.floor(root);
        double ceiling = Math.ceil(root);
        double floorSquared = floor * floor;
        double ceilingSquared = ceiling * ceiling;
        double floorDistance = num - floorSquared;
        double ceilingDistance = ceilingSquared - num;

        if (floorDistance < ceilingDistance) {
            return floor;
        } else {
            return ceiling;
        }
    }

    // Allows sorting lists
    public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
      List<T> list = new ArrayList<T>(c);
      java.util.Collections.sort(list);
      return list;
    }
}
