package util;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法类模板
 *
 * @author Noblel
 */
public class Utils {
    /**
     * v < w返回为true
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        //单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
