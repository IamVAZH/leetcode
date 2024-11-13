package problems.medium.binary;

import java.util.Arrays;

public class Task34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 4, 5, 56}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,3,5,8,8,8,8,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2}, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            if (target >= nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int lastPosition = l;

        l = -1;
        r = nums.length - 1;
        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        int firstPosition = r;

        return new int[]{firstPosition, lastPosition};
    }
}
