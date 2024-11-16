package problems.medium.prefix.sum;

import java.util.HashMap;
import java.util.Map;

public class Task560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    // brute force with time: O(n2) and space: O(1)
//    public static int subarraySum(int[] nums, int k) {
//        int counter = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == k) {
//                counter++;
//            }
//
//            int sum = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    counter++;
//                }
//            }
//        }
//
//        return counter;
//    }

    // O(n) and space: O(n)
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        int counter = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int sumToCut = prefixSum - k;
            counter += prefixSums.getOrDefault(sumToCut, 0);
            prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        }

        return counter;
    }
}