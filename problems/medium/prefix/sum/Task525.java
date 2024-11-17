package problems.medium.prefix.sum;

import java.util.HashMap;
import java.util.Map;

public class Task525 {
    public static void main(String[] args) {

    }

    // brute force may be works but Time Limit Exceeded
//    public static int findMaxLength(int[] nums) {
//        int result = 0;
//        int zeroSum = 0;
//        int oneSum = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == 0) {
//                    zeroSum++;
//                } else {
//                    oneSum++;
//                }
//
//                if (zeroSum == oneSum && result / 2 < zeroSum) {
//                    result = zeroSum + oneSum;
//                }
//            }
//        }
//        return result;
//    }

    // best solution O(n) O(n)
    // save differences between ones and zeros and then check for them or put in hashMap or check for zero = one
    public static int findMaxLength(int[] nums) {
        int result = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            if (zero == one) {
                result = zero + one;
            } else if (hashMap.get(one - zero) != null) {
                result = Math.max(result, i - hashMap.get(one - zero));
            } else {
                hashMap.put(one - zero, i);
            }
        }
        return result;
    }
}
