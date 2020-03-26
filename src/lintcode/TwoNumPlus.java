package lintcode;

/**
 * 使用二进制实现两个数相加
 *
 * @author Noblel
 */
class TwoNumPlus {
    public static int aPlusB(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return aPlusB(sum, carry);
    }
}
