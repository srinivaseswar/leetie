// ──────────────────────────────────────────────────
// Problem  : 345. Reverse Vowels of a String
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-vowels-of-a-string/
// Runtime  : 2 ms (beats 99%)
// Memory   : 46600000 (beats 64%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        // Fast ASCII lookup array for vowels
        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Move left pointer until a vowel is found
            while (left < right && !isVowel[arr[left]]) {
                left++;
            }
            // Move right pointer until a vowel is found
            while (left < right && !isVowel[arr[right]]) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }
}