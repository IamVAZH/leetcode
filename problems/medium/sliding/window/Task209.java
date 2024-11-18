package problems.medium.sliding.window;

public class Task209 {
    public static void main(String[] args) {
    }

    // first try but problems with attention to special cases
    // O(n) O(1)
    //    public static int minSubArrayLen(int target, int[] nums) {
    //        int minCount = Integer.MAX_VALUE;
    //        int sum = 0;
    //        int count = 0;
    //        int left = 0;
    //
    //        for (int right = 0; right < nums.length; right++) {
    //            sum += nums[right];
    //            count++;
    //            if (sum >= target) {
    //                minCount = Math.min(minCount, count);
    //                while (sum >= target) {
    //                    sum -= nums[left];
    //                    left++;
    //                    count--;
    //                    if (sum >= target) {
    //                        minCount = Math.min(minCount, count);
    //                    }
    //                }
    //            }
    //        }
    //        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    //    }

    // best solution after deleting some extra params and checks
    // while can be used as if+forLoop its amazing lol ^_^
    public static int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minCount = Math.min(minCount, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
