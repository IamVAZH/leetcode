package problems.medium;

public class Task845 {

    public static void main(String[] args) {

    }

    // brute force slow and not good but works
//    public static int longestMountain(int[] arr) {
//        if (arr.length < 3) {
//            return 0;
//        }
//
//        int max = 0;
//        for(int i=0; i<arr.length;i++) {
//            int pointer = i;
//            while (pointer < arr.length - 1) {
//                if (arr[pointer + 1] > arr[pointer]) {
//                    pointer++;
//                } else {
//                    break;
//                }
//            }
//
//            int mid = pointer;
//            while (pointer < arr.length - 1) {
//                if (arr[pointer + 1] < arr[pointer]) {
//                    pointer++;
//                } else {
//                    break;
//                }
//            }
//
//            if (i == mid || mid == pointer) {
//                continue;
//            }
//
//            if (max < pointer - i + 1) {
//                max = pointer - i + 1;
//            }
//        }
//
//        return max;
//    }

    // space O(1) time O(n)
    // time: we will choose only peaks and go through every point only once except for the foots.
    // it will be used twice
    // altogether it will be 2*O(n) = O(n)
    public static int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                int leftPointer = i - 1;
                while (leftPointer > -1 && arr[leftPointer - 1] < arr[leftPointer]) {
                    leftPointer--;
                }
                int rightPointer = i + 1;
                while (rightPointer < arr.length-1 && arr[rightPointer + 1] < arr[rightPointer]) {
                    rightPointer++;
                }

                if (rightPointer - leftPointer + 1 > max) {
                    max = rightPointer - leftPointer + 1;
                }
            }
        }

        return max;
    }
}
