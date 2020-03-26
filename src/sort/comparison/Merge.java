package sort.comparison;

import static util.Utils.less;

/**
 * 归并排序
 *
 * @author Noblel
 */
public class Merge {
    /**
     * 归并所需要的数组
     */
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下排序
     *
     * @param a  需要排序的数据
     * @param lo 排序的最低位
     * @param hi 排序的最高位
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //左半部分排序
        sort(a, lo, mid);
        //右半部分排序
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 自底向上排序
     * @param a 排序数据
     */
    private static void downToTopSort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
