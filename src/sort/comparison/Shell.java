package sort.comparison;

import util.Utils;

/**
 * 希尔排序(基于插入排序的快速的排序算法)
 * 时间复杂度-(nlogn-n6/5)
 *
 * @author Noblel
 */
public class Shell {
    private static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //1,4,13,40,121,364....
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //将数组变成h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && Utils.less(a[j], a[j - h]); j -= h) {
                    Utils.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}