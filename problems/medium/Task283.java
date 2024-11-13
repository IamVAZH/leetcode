package problems.medium;

import java.util.Arrays;

public class Task283 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
//        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{1,1,1})));
    }

    // my brute force solution not the best and some additional lines but works
//    public static int[] moveZeroes(int[] nums) {
//        int zeroPointer = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                zeroPointer = i;
//                break;
//            }
//        }
//        if (zeroPointer == -1) {
//            return nums;
//        }
//
//        for (int i = zeroPointer + 1; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[zeroPointer] = nums[i];
//                nums[i] = 0;
//                zeroPointer++;
//            }
//        }
//
//        return nums;
//    }
//
    public static int[] moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        for (int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
// 1, 2, 0, 11, 0, 12
// 1, 2, 11, 12, 0, 0
