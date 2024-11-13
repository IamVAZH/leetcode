package problems.medium.signs;

import java.util.ArrayList;
import java.util.List;

public class Task442 {
    public static void main(String[] args) {
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i < nums.length;i++) {
            int position = Math.abs(nums[i]);
            int digit = nums[position - 1];
            if (digit < 0) {
                result.add(position);
            } else {
                nums[position - 1] *= -1;
            }
        }

        return result;
    }
}
