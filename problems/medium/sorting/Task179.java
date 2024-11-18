package problems.medium.sorting;

import java.util.Arrays;

public class Task179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    // no good brute force and many string methods idk. Hard task
//    public static String largestNumber(int[] nums) {
//        String[] strNums = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            strNums[i] = Integer.toString(nums[i]);
//        }
//
//        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < strNums.length; i++) {
//            sb.append(strNums[i]);
//        }
//
//        return sb.toString();
//    }

    // better solution and less non-common methods
    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        return sb.toString();
    }
}
