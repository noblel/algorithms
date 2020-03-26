package sort.comparison;

import util.Utils;

/**
 * *********************
 * 三向切分快速排序
 * 时间复杂度-(N-NlogN)
 * 空间复杂度-(lgN)
 * 原地排序
 * 不稳定
 * **********************
 * 适合有重复元素的数据
 * **********************
 *
 * @author Noblel
 */
public class Quick3way {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * 使用一子数组的一小部分元素的中位数来切分数组,取样为3并用大小居中的元素切分效果很好,所以使用三向切分
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                Utils.exch(a, lt++, i++);
            } else if (cmp > 0) {
                Utils.exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
