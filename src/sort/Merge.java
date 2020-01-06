package sort;

public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int M) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, M);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
//        sort(a, lo, hi, 0);
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > lo) a[k] = aux[i++];
            else if (BasicFun.less(a[i], a[j])) a[k] = a[i++];
            else a[k] = a[j++];
        }
    }

    public static void sort(Comparable[] a, int lo, int hi, int M) {
        if (lo + M >= hi) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}
