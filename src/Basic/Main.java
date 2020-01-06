package Basic;

import priority_queue.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MaxPQ<Integer> mpq = new MaxPQ<>(10);
        int[] a = { 3, 5, 2, 6, 1, 7, 2, 8, 7};
        for (int i:a)
            mpq.insert(i);
        while(!mpq.isEmpty())
            System.out.println(mpq.delMax());
    }
}
