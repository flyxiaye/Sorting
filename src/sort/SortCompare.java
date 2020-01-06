package sort;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Merge_M")) Merge.sort(a, 5);
        if (alg.equals("Quick")) Quick.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = Math.random();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 5000000;
        double t1 = timeRandomInput("Merge", N, 2);
        double t2 = timeRandomInput("Quick", N, 2);
        System.out.println(t1/t2);
//        Double[] a = new Double[N];
//        for (int i = 0; i < N; i++)
//            a[i] = Math.random();
//        Merge.sort(a);
//        for (double i : a)
//            System.out.println(i + " ");
    }
}
