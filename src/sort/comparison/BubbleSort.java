package sort.comparison;

import util.Utils;

/**
 * 冒泡排序
 *
 * @author Noblel
 */
public class BubbleSort {
    public static void sort(Comparable[] a) {
        //将a[]按升序排序
        int N = a.length;
        for (int i = N - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (a[j + 1].compareTo(a[j]) < 0){
                    Utils.exch(a, j +1 , j);
                }
            }
        }
    }
}
