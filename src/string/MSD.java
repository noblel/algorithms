package string;

/**
 * 高位优先字符串排序(从左向右)
 * 长度可以不一样
 * 稳定排序
 * 时间复杂度O(N)~O(Nw) w为字符串平均长度
 * 空间复杂度O(N+WR) W为最大长度,O(WR)是W次递归中count[R+2]数组占用的空间
 * 高位优先字符串排序一般用于随机字符串排序，在有大量重复字符串时效率低下（此时可以使用三向字符串快速排序）
 *
 * @author Noblel
 */
class MSD {
    public static void main(String[] args) {
        String[] strings = {
                "she", "sells", "seashells", "by", "the",
                "seashore", "the", "shells",
                "she","sells","are","surely","seashells"
        };
        sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 基数
     */
    private static int R = 256;

    /**
     * 小数组的切换阈值
     */
    private static final int M = 15;

    /**
     * 数组分类的辅助数组
     */
    private static String[] aux;


    /**
     * 判断是否到达末尾
     * 字符索引大于字符长度即字符串达到结尾时，返回-1
     */
    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            //直接使用插入排序
            insertion(a, lo, hi, d);
            return;
        }
        //计算频率
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        //将频率转换为索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        //数据分类
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        //回写
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        //递归的以每个字符为键进行排序
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for(int i = lo; i <= hi; ++i) {
            for(int j = i; j > lo && less(a[j], a[j - 1], d); --j) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        for(int i = d; i < Math.min(v.length(), w.length()); ++i) {
            if (v.charAt(i) < w.charAt(i)) {
                return true;
            }

            if (v.charAt(i) > w.charAt(i)) {
                return false;
            }
        }
        return v.length() < w.length();
    }
}
