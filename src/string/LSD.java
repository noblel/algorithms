package string;

/**
 * 低位优先的字符串排序(从右向左)
 * 适合字符串长度都一样
 * 稳定排序
 * 时间复杂度是O(WN),W是字符串长度,N是字符串个数
 * 空间复杂度是O(R+N),R是count数组大小
 * 低位优先字符串排序适合定长较短字符串排序,相比于高位优先字符串排序,优势在于编写简单
 *
 * @author Noblel
 */
class LSD {

    /**
     * @param a 排序字符串数组
     * @param W 通过前w个字符将a排序
     */
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        //根据第d个字符用键位索引计数法排序
        for (int d = W-1; d >= 0; d--) {
            //计算出现的频率
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            //将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
