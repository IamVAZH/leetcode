package problems.medium.sorting;

import java.util.Arrays;

public class Task973 {

    public static void main(String[] args) {
        int[][] points1 = new int[][]{{1, 3}, {-2, 2}};
        int[][] points2 = new int[][]{{3, 3}, {5, -1}, {-2, 4}};

        System.out.println(Arrays.deepToString(kClosest(points1, 1))); //[[-2,2]]
        System.out.println(Arrays.deepToString(kClosest(points2, 2))); //[[3,3],[-2,4]]
    }

    // answer with custom sort easy and fast. First sort then copy k elements
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1,p2) -> (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0] + p2[1]*p2[1])); // logN - space; O(NlogN) = time
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }
}
