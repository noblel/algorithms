package sort.comparison;


import util.Utils;

/**
 * *********************
 * 快速排序
 * **********************
 * 不适合元素重复率特别高
 * **********************
 * 长度为N的无重复排序,快速排序平均需要2NlnN次比较和 1/6 次比较
 * **********************
 *
 * @author Noblel
 */
public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //替换上面的语句,对小数组使用插入排序,M为子数组元素,最佳值和系统有关,但是5-15之间任意值在大多数情况下都不错
//        if (hi <= lo + M) {
//            Insertion.base.sort(a, lo, hi);
//            return;
//        }

        //查找切分点
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 查找切分点
     * 1.分别选取a[lo],a[hi]为切分元素
     * 2.从左向右扫描直到找到一个小于等于它的元素，交换位置，保证了从左向右不大于切分元素a[i]
     * 3.从右向左扫描直到找到一个大于等于它的元素，交换位置,保证了从右向左不小于切分元素a[j]
     * 4.两个指针相遇，只需要将切分元素a[i]和左数组最右侧元素a[j]交换返回j
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (Utils.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (Utils.less(v, a[--j])) {
                //由于v就是a[lo]，他不可能比自己小，所以下面的可以省略
//                if (j == lo) {
//                    break;
//                }
            }
            if (i >= j) {
                break;
            }
            Utils.exch(a, i, j);
        }
        Utils.exch(a, lo, j);
        return j;
    }
}
