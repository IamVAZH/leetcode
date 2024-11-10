package problems.medium.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); //[0,6]
        System.out.println(findAnagrams("abab", "ab")); //[0,1,2]
        System.out.println(findAnagrams("baa", "aa")); //[1]
    }

// brute force but time exceeded (Time Limit Exceeded)
//    public static List<Integer> findAnagrams(String s, String p) {
//        if (p.length()  > s.length()) {
//            return new ArrayList<>();
//        }
//
//        Map<Character, Integer> letters = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i=0; i< p.length(); i++) {
//            letters.put(p.charAt(i), letters.getOrDefault(p.charAt(i), 0) + 1);
//        }
//        for (int i =0; i < s.length() - p.length() + 1; i++) {
//            Map<Character, Integer> searchLine = new HashMap<>();
//            for(int j = i; j < i + p.length(); j++) {
//                searchLine.put(s.charAt(j), searchLine.getOrDefault(s.charAt(j), 0) + 1);
//            }
//            int c = 0;
//            for (Map.Entry<Character, Integer> pair: searchLine.entrySet()) {
//                if ( letters.getOrDefault(pair.getKey(),0).equals(pair.getValue())) {
//                    c++;
//                }
//            }
//            if (c == letters.size()) {
//                result.add(i);
//            }
//        }
//
//        return result;
//    }

    //hard solution with slidingWindow adding and removing 1 element at iteration. Time: O(s) Space: O(n)
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        Map<Character, Integer> letters = new HashMap<>();
        Map<Character, Integer> slidingWindow = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            letters.put(p.charAt(i), letters.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            slidingWindow.put(s.charAt(i), slidingWindow.getOrDefault(s.charAt(i), 0) + 1);
        }

        int leftCorner = 0;
        int rightCorner = p.length() - 1;
        List<Integer> result = new ArrayList<>();
        if (sameCounters(letters, slidingWindow)) {
            result.add(leftCorner);
        }

        while (rightCorner + 1 < s.length()) {
            char cToDelete = s.charAt(leftCorner);
            slidingWindow.put(cToDelete, slidingWindow.get(cToDelete) - 1);
            char cToAdd = s.charAt(rightCorner + 1);
            slidingWindow.put(cToAdd, slidingWindow.getOrDefault(cToAdd, 0) + 1);
            leftCorner++;
            rightCorner++;
            if (sameCounters(letters, slidingWindow)) {
                result.add(leftCorner);
            }
        }

        return result;
    }

    public static boolean sameCounters(Map<Character, Integer> counter1, Map<Character, Integer> counter2) {
        for (Map.Entry<Character, Integer> counter: counter1.entrySet()) {
            if (!counter2.getOrDefault(counter.getKey(), 0).equals(counter.getValue())) {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> counter: counter2.entrySet()) {
            if (!counter1.getOrDefault(counter.getKey(), 0).equals(counter.getValue())) {
                return false;
            }
        }

        return true;
    }
}