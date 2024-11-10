package problems.easy.prefix.sum;

import java.util.ArrayList;

public class Task53 {

    public static void main(String[] args) {
        var nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6
        var nums2 = new int[]{1}; // 1
        var nums3 = new int[]{5, 4, -1, 7, 8}; // 23
        var nums4 = new int[]{-1}; // 0
        var nums5 = new int[]{-2, -1}; // -1

        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
        System.out.println(maxSubArray(nums5));
    }

// brute force but "Time Limit Exceeded"
//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            int localSum = nums[i];
//            if (localSum > max) {
//                max = localSum;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                localSum += nums[j];
//                if (localSum > max) {
//                    max = localSum;
//                }
//            }
//        }
//
//        return max;
//    }

    //currPref + minPref + answer
    public static int maxSubArray(int[] nums) {
        int currentPrefix = 0;
        int minPrefix = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentPrefix += nums[i];
            answer = Math.max(answer, currentPrefix - minPrefix);
            if (currentPrefix < minPrefix) {
                minPrefix = currentPrefix;
            }
        }

        return answer;
    }
}
//
// 1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//
// [-1]
// cur_pref =  0    -1
// min_pref =  0    -1
// answer =    0     0
// [-2,1,-3,4,-1,2,1,-5,4]
// cur_pref =  0    -2    -1  -4   0  -1   1   2   -3  1
// min_pref =  0     0    -2  -2  -4  -4  -4  -4  -4  -4
// answer =    0  -> 0     1-> 1   4-> 4   5   6   6   6