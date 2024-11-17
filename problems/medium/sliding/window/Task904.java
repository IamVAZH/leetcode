package problems.medium.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Task904 {
    public static void main(String[] args) {
        totalFruit(new int[]{0, 1, 2, 2});
    }

    //brute force but Time Limit Exceeded
//    public static int totalFruit(int[] fruits) {
//        int maxTotal = 0;
//
//        if (fruits.length == 1) {
//            return 1;
//        }
//
//        for (int i=0; i< fruits.length-1; i++) {
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            hashMap.put(fruits[i], 1);
//            for (int j=i+1; j< fruits.length; j++) {
//                int type = fruits[j];
//                if (hashMap.get(type) == null && hashMap.size() == 2) {
//                    break;
//                }
//                hashMap.put(type,hashMap.getOrDefault(type, 0) + 1);
//            }
//
//            int total = 0;
//            for (Integer counter: hashMap.values()) {
//                total += counter;
//            }
//
//            maxTotal = Math.max(maxTotal, total);
//        }
//
//        return maxTotal;
//    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        int totalMax = 0;
        int localMax = 0;
        for (int right = 0; right < fruits.length; right++) {
            int type = fruits[right];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            localMax++;

            while (hashMap.size() > 2) {
                int typeToRemove = fruits[left];
                if (hashMap.get(typeToRemove) == 1) {
                    hashMap.remove(typeToRemove);
                } else {
                    hashMap.put(typeToRemove, hashMap.get(typeToRemove) - 1);
                }
                left++;
                localMax--;
            }
            totalMax = Math.max(totalMax, localMax);
        }
        return totalMax;
    }
}
