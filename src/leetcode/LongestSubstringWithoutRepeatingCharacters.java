package leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 *
 * @author Noblel
 */
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbsccvcgfdgfdhbgfnhgjhgm"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        //字符串缓存
        int[] cache = new int[128];
        //从第一个位置依次查找
        for (int i = 0,j = 0; i < s.length(); i++) {
            //cache[s.charAt(i)] > 0说明已经重复,值为j和cache[s.charAt(i)]最大值,如果。没有出现过就为0
            //把上一个未出现重复位置值赋值给j
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            //i-j+1为不重复的个数
            result = Math.max(result, i - j + 1);
            //cache[s.charAt(i)]-0 1 2 3 4 0 0 7 0  8  0  0  0 11 12 13  0  5 14 15  0 17 19  0 22 23  0
            //i------------------0 1 2 3 4 5 6 7 8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
            //j------------------0 1 2 3 4 4 4 7 7  8  8  8  8 11 12 13 13 13 14 15 15 17 19 19 22 23 23
            //cache[s.charAt(i)]-1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27
            //result-------------1 1 1 1 1 2 3 3 3  3  3  4  5  5  5  5  5  5  5  5  6  6  6  6  6  6  6
        }
        return result;
    }
}
