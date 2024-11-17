package problems.medium.sliding.window;

public class Task643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    // brute force with time limit acceded
//    public static double findMaxAverage(int[] nums, int k) {
//        double answer = Integer.MIN_VALUE;
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        for (int i =0; i< nums.length-k+1; i++) {
//            double sum = nums[i];
//            for (int j = i+1; j < i+k; j++) {
//                sum += nums[j];
//            }
//
//            answer = Math.max(answer,sum/k);
//        }
//
//        return answer;
//    }

    // my own solution is the best it is using sliding window approach and preparation for it
    // O(n) O(1)
    public static double findMaxAverage(int[] nums, int k) {
        double sumK = 0;
        for (int i = 0; i < k; i++) {
            sumK += nums[i];
        }

        double answer = sumK;
        for (int i = k; i < nums.length; i++) {
            sumK -= nums[i - k];
            sumK += nums[i];

            answer = Math.max(answer, sumK);
        }

        return answer / k;
    }
}
