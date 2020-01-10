package sort;

import javax.swing.*;
import java.util.Comparator;

public class BasicFun {
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (!less(a[i], a[i + 1]))
                return false;
        return true;
    }
    public static boolean isSorted(double[] a){
        for (int i = 0; i < a.length - 1; i++)
            if (!less(a[i], a[i + 1]))
                return false;
        return true;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            System.out.print(a + " ");
    }

    public static boolean less(Comparator c, Object v, Object w){
        return c.compare(v, w) < 0;
    }

    public static void exch(Object[] a, int i, int j){
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}




