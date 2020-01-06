package sort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author win7-s
 */
public class MyThread extends Thread {

    private double[] arr;
    private int lo;
    private int hi;
    public static int minHi = 0;
    MyThread lastThread;
    public int pos;
    public int weightOrder;

    MyThread(double[] arr, int order) {
        this.arr = arr;
        lo = 0;
        minHi--;
        hi = minHi;
        this.weightOrder = order;
        this.pos = lo;
    }

    @Override
    public void run() {
        while (hi > lo) {
            for (pos = 0; pos < hi; ) {
                if (this.weightOrder == 2 ||
                        pos + 3 < this.lastThread.pos) {
                    if (arr[pos] > arr[pos + 1]) {
                        double tmp = arr[pos];
                        arr[pos] = arr[pos + 1];
                        arr[pos + 1] = tmp;
                    }
                    pos++;
                }

//                if (i > lo + 1) {
//                    synchronized (this) {
//                        try {
//                            this.wait();
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    synchronized (this.lastThread) {
//                        this.lastThread.notify();
//                    }
//                }
            }
            for (MyThread mt : BubbleSortThread.vm){
                if (this == mt) mt.weightOrder = 0;
                else mt.weightOrder++;
            }
            hi = --minHi;
        }
    }

    public void set(int hi) {
        this.hi = hi;
    }
}

