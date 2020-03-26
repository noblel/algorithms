package util;


import static sort.comparison.Heap.sort;

/**
 * @author Noblel
 */
class Test {
    public static void main(String[] args) {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        Utils.show(a);
    }
}
