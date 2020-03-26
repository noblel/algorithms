package sort.uncomparison;

/**
 * 基数排序
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较。
 *
 * @author Noblel
 */
public class RadixSort {

    public static void main(String[] args) {
        sort(new int[]{10,500,60,25,40,20,90,30,100},8);
    }

    /**
     * 使用基数排序
     *
     * @param data 数组
     * @param n 排序的大小
     */
    public static void sort(int[] data, int n) {
        int d = maxbit(data, n);
        int[] temp = new int[n];
        //计数器
        int[] count = new int[10];
        int i, j, k;
        int radix = 1;
        //进行d次排序
        for (i = 0; i <= d; i++) {
            for (j = 0; j < 10; j++) {
                //每次分配前清空计数器
                count[j] = 0;
            }
            for (j = 0; j < n; j++) {
                //统计每个桶中的记录数
                k = (data[j] / radix) % 10;
                count[k]++;
            }
            for (j = 1; j < 10; j++) {
                //将temp中的位置依次分配给每个桶
                count[j] = count[j - 1] + count[j];
            }
            //将所有桶中的记录依次收集到temp中
            for (j = n - 1; j >= 0; j--) {
                k = (data[j] / radix) % 10;
                temp[count[k] - 1] = data[j];
                count[k]--;
            }
            //将临时数组的内容复制到data中
            for (j = 0; j < n; j++) {
                data[j] = temp[j];
            }
            radix = radix * 10;
        }
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    /**
     * 辅助函数,求数据的最大位数
     */
    private static int maxbit(int[] data, int n) {
        //最大数
        int maxData = data[0];
        for (int i = 1; i < n; i++) {
            if (maxData < data[i]) {
                maxData = data[i];
            }
        }
        int d = 1;
        int p = 10;
        while (maxData >= p) {
            maxData /= 10;
            ++d;
        }
        return d;
    }
}
