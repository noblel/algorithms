package leetcode;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * <p>
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 * @author Noblel
 */
class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String J, String S) {
        int j = J.length();
        int s = S.length();
        int result = 0;
        for (int k = 0; k < s; k++) {
            for (int i = 0; i < j; i++) {
                if (J.charAt(i) == S.charAt(k)) {
                    result++;
                }
            }
        }
        return result;
    }
}
