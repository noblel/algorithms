# Algorithms

算法学习

# 比较排序

|   算法   |时间复杂度|最差情况   |空间复杂度 |是否稳定|是否原地|  备注  |
| -------- |----------|-----------|-----------|--------|--------|--------|
| 冒泡排序 | $O(N^2)$ |$O(N^2)$   |$O(1)$     |   是   |   是   |N小时较好|
| 选择排序 | $O(N^2)$ |$O(1)$     |$O(1)$     |   否   |   是   |N小时较好|
| 插入排序 | $O(N-N^2)$ |$O(N^2)$   |$O(1)$     |   是   |   是   |大部分已排序时使用|
| 希尔排序 | $O(NlogN)?O(N^{6/5})?$ |$O(N^2)$   |$O(1)$   |   否   |   是 |时间复杂度根据步长序列的不同而不同|
| 快速排序 | $O(NlogN)$   |$O(N^2)$   |$O(lgN)$   |   否   |   是   |快排是最快的通用排序算法|
| 归并排序 | $O(NlogN)$   |$O(NlogN)$ |$O(N)$     |   是   |   否   |N大时较好，稳定性重要,空间又不是问题，归并可能是最好|
|  堆排序  | $O(NlogN)$   |$O(NlogN)$ |$O(1)$   |   否   |   是   |解决M个数中前K个最大或最小的问题|

# 非比较排序

|   算法   |时间复杂度|最差情况|空间复杂度|是否稳定|是否原地|  备注  |
| -------- |----------|--------|----------|--------|--------|--------|
|  桶排序  | $O(N+K)$ |$O(N^2)$|$O(N*K)$  |   是   |   否   |$K = N*(logN-logM)$ 最大最小值相差较大的时候使用，N待排数据,M个桶|
| 基数排序 | $O(N*K)$ |$O(N+K)$|$O(K*N)$  |   是   |   否   | $K=log_B(M)$其中B是采取的基数,M是堆数
| 计数排序 | $O(N+K)$ |$O(N+K)$|$O(N+K)$  |   是   |   否   |K是整数的范围|

(1)若n较小(如n≤50)，可采用直接插入或直接选择排序。
    　当记录规模较小时，直接插入排序较好；否则因为直接选择移动的记录数少于直接插人，应选直接选择排序为宜。
(2)若文件初始状态基本有序(指正序)，则应选用直接插人、冒泡或随机的快速排序为宜；
(3)若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。
    　快速排序是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
    　堆排序所需的辅助空间少于快速排序，并且不会出现快速排序可能出现的最坏情况。这两种排序都是不稳定的。
    　若要求排序稳定，则可选用归并排序。但本章介绍的从单个记录起进行两两归并的  排序算法并不值得提倡，通常可以将它和直接插入排序结合在一起使用。先利用直接插入排序求得较长的有序子文件，然后再两两归并之。因为直接插入排序是稳定 的，所以改进后的归并排序仍是稳定的。
