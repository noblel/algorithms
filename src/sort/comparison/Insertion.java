package sort.comparison;

import util.Utils;

/**
 * 插入排序
 *
 * @author Noblel
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        //将a[]按升序排序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && Utils.less(a[j], a[j - 1]); j--) {
                Utils.exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //将a[]按升序排序
        if (lo >= hi && lo < 0)  {
            return;
        }
        int N = hi - lo;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && Utils.less(a[j], a[j - 1]); j--) {
                Utils.exch(a, j, j - 1);
            }
        }
    }
}