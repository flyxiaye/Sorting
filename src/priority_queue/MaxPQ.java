package priority_queue;

public class MaxPQ <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public void insert(Key v){
        if (N > pq.length) return;
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key v = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;
        sink(1);
        return v;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private void swim(int k){
        while(k != 1){
            int j = k / 2;
            if (!less(j, k)) return;
            exch(j, k);
            k = j;
        }
    }
    private void sink(int k){
        int j;
        while((j= 2 * k) <= N){
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) return;
            exch(k, j);
            k = j;
        }
    }
}
