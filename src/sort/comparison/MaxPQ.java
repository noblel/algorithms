package sort.comparison;

/**
 * *****************
 * 基于堆的优先队列
 * *****************
 * 索引优先队列,
 * *****************
 *
 * @author Noblel
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     * 基于堆的完全二叉树
     */
    private Key[] pq;

    /**
     * 存储于pq[1...N]中, pq[0]没有使用
     */
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 插入实现
     * 不超过(lgN + 1)次比较
     * @param v 插入值
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * 删除最大值
     * 不超过(2lgN)次比较
     * @return 删除的最大值
     */
    public Key delMax() {
        //从根节点得到最大元素
        Key max = pq[1];
        //将它和最后一个位置交换
        exch(1, N--);
        pq[N+1] = null;
        //执行下沉操作
        sink(1);
        return max;
    }

    /**
     * 上浮实现
     * @param k 上浮的元素位置
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉实现
     * @param k 下沉的元素位置
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j< N && less(j, j+ 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
