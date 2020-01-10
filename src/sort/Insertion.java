package sort;

import java.util.Comparator;

public class Insertion {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && BasicFun.less(a[j], a[j - 1]); j--) {
                BasicFun.exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && BasicFun.less(c, a[j], a[j - 1]); j--)
                BasicFun.exch(a, j, j - 1);
    }


}
