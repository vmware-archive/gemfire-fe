package io.pivotal.bds.gemfire.fraud.server.util;

import java.util.List;

public class Utils {

    public static int[] convertToIntVector(List<Integer> list) {
        int[] d = new int[list.size()];
        for (int i = 0; i < d.length; ++i) {
            d[i] = list.get(i);
        }
        return d;
    }

    public static double[][] convertToMatrix(List<Double> list) {
        double[][] d = new double[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            d[i] = new double[1];
            d[i][0] = list.get(i);
        }
        return d;
    }
}
