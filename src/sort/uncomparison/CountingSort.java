package sort.uncomparison;

/**
 * 计数排序
 * 对一定范围内的整数排序
 *
 * @author Noblel
 */
class CountingSort {

    public static void main(String[]args){
        //排序的数组
        int a[]={100,93,97,92,96,99,92,89,93,97,90,94,92,95};
        int b[]=sort(a);
        for(int i:b){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int[] sort(int[] arr) {
        int[] temp = new int[arr.length];
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int k = max - min +1;
        int[] ktemp = new int[k];
        for (int i = 0; i < arr.length; ++i) {
            ktemp[arr[i] - min] += 1;
        }
        for (int i = 1; i < ktemp.length; ++i) {
            ktemp[i] = ktemp[i] + ktemp[i-1];
        }

        for (int i = arr.length - 1; i >= 0 ; --i) {
            temp[--ktemp[arr[i] - min]] = arr[i];
        }
        return temp;
    }
}
