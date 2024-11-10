package problems.easy.signs;

import java.util.ArrayList;
import java.util.List;

// Find All Numbers Disappeared in an Array
public class Task448 {
    public static void main(String[] args) {
        var nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1}; // [5,6]
        var nums2 = new int[]{1, 1}; // [2]

        System.out.println(findDisappearedNumbers(nums1));
        System.out.println(findDisappearedNumbers(nums2));
    }

//    brute force
//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> digits = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            digits.add(0);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int digit = nums[i];
//            digits.set(digit - 1,digits.get(digit - 1) + 1);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (digits.get(i) == 0) {
//                result.add(i+1);
//            }
//        }
//
//        return result;
//    }

    //changing a sign of every digit that we have seen
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int digit = Math.abs(nums[i]);
            nums[digit - 1] = Math.abs(nums[digit - 1]) * -1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
// array nums of n integers
// return an array of all the integers in the range [1, n] that do not appear in nums
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n

// because in the range [1, n] then we can switch digit signs to negative
// 4,3,2,7,8,2,3,1
// 4,3,2,-7,8,2,3,1
// 4,3,-2,-7,8,2,3,1
// 4,-3,-2,-7,8,2,3,1
// 4,-3,-2,-7,8,2,-3,1
// 4,-3,-2,-7,8,2,-3,-1
// 4,-3,-2,-7,8,2,-3,-1
// -4,-3,-2,-7,8,2,-3,-1