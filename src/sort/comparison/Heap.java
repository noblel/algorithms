package sort.comparison;


/**
 * 堆排序
 *
 * @author Noblel
 */
public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length;
        //构造堆
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        //下沉排序
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    /**
     * 交换位置值
     */
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }

    /**
     * 下沉排序
     *
     * @param a 下沉源数据数组
     * @param k 下沉开始值坐标
     * @param n 下沉终结值坐标--从下沉开始值不断乘2，判断是否到达终结值坐标,比如2-11,就可能会把坐标为2一直向下和4,8/9...交换
     */
    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }
}
