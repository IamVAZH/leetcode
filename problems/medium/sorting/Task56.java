package problems.medium.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {2, 3}})));
    }

    // not the brute force but very medium because of methods and 1 edge case
//    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(List.of(intervals[0][0], intervals[0][1]));
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (result.get(result.size() - 1).get(1) < intervals[i][0]) {
//                result.add(List.of(intervals[i][0], intervals[i][1]));
//            } else {
//                int end = result.get(result.size() - 1).get(1) > intervals[i][1] ? result.get(result.size() - 1).get(1) : intervals[i][1];
//                result.set(result.size() - 1, List.of(result.get(result.size() - 1).get(0), end));
//            }
//        }
//
//        int[][] arrResult = new int[result.size()][2];
//        for (int i = 0; i < result.size(); i++) {
//            arrResult[i] = new int[]{result.get(i).get(0), result.get(i).get(1)};
//        }
//
//        return result.toArray(new int[result.size()][]);
//    }

    //better without extra code
    // new for me is List<int[]> and toArray(new int[...][])
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (result.get(result.size() - 1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
