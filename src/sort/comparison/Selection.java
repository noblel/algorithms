package sort.comparison;

import util.Utils;

/**
 * 选择排序
 *
 * @author Noblel
 */
public class Selection {
    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Utils.less(a[j], a[min])) {
                    min = j;
                }
            }
            Utils.exch(a, i, min);
        }
    }
}
