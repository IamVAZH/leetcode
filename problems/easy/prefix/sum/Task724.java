package problems.easy.prefix.sum;

import java.util.ArrayList;
import java.util.List;

public class Task724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3
//        System.out.println(pivotIndex(new int[]{1, 2, 3})); // -1
//        System.out.println(pivotIndex(new int[]{2, 1, -1})); // 0
    }

    // brute force with acceptance, first try
//    public static int pivotIndex(int[] nums) {
//        int resultIndex = -1;
//
//        int[] prefixes = new int[nums.length + 1];
//        prefixes[0] = 0;
//        for(int i=1; i < nums.length + 1; i++) {
//            prefixes[i] = prefixes[i - 1] + nums[i - 1];
//        }
//
//        int[] postfixes = new int[nums.length+1];
//        postfixes[nums.length] = 0;
//        for(int i=nums.length - 1; i>-1; i--) {
//            postfixes[i] = postfixes[i+1] + nums[i];
//        }
//
//        for (int i =0; i < nums.length; i++) {
//            if (prefixes[i] - postfixes[i + 1] == 0) {
//                resultIndex = i;
//                break;
//            }
//        }
//
//        return resultIndex;
//    }
    // 1,7,3,6,5,6
    // prefixes  = [ 0, 1, 8, 11, 17, 23, 29]
    // postfixes = [28,27,20, 17, 11,  6,  0]
    // checks ->
    // 0 - 27 != 0
    // 1 - 20 != 0
    // 8 - 17 != 0
    // 11 - 11 == 0
    // output: 3

    // time: O(n)
    // space: O(n)

    // best solution but some problems with indexes
//    public static int pivotIndex(int[] nums) {
//        int resultIndex = -1;
//
//        int[] postF = new int[nums.length + 1];
//        postF[nums.length] = 0;
//        for (int i = nums.length - 1; i > -1; i--) {
//            postF[i] = postF[i + 1] + nums[i];
//        }
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (postF[i + 1] - sum == 0) {
//                resultIndex = i;
//                break;
//            }
//
//            sum += nums[i];
//        }
//
//        return resultIndex;
//    }

    // alternative solution with list and reverse indexes
    public static int pivotIndex(int[] nums) {
        List<Integer> postfix = new ArrayList<>();

        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            postfix.add(sum);
            sum += nums[i];
        }

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == postfix.get(nums.length - 1 - i)) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
