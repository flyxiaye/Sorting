package sort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Vector;

/**
 *
 * @author win7-s
 */
public class BubbleSortThread {
    public static Vector<MyThread> vm;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] a = new double[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }
        MyThread.minHi = a.length;
        vm = new Vector();
        vm.addElement(new MyThread(a, 2));
        vm.addElement(new MyThread(a, 1));
        vm.addElement(new MyThread(a, 0));
        ((MyThread)vm.elementAt(0)).lastThread = (MyThread)vm.elementAt(2);
        ((MyThread)vm.elementAt(1)).lastThread = (MyThread)vm.elementAt(0);
        ((MyThread)vm.elementAt(2)).lastThread = (MyThread)vm.elementAt(1);
        ((MyThread)vm.elementAt(0)).start();
        ((MyThread)vm.elementAt(1)).start();
        ((MyThread)vm.elementAt(2)).start();
//        mt2.start();
//        mt3.start();
//        BubbleSort.sort(a, 0, a.length -1);
        while (((MyThread)vm.elementAt(2)).isAlive()
                || ((MyThread)vm.elementAt(1)).isAlive()
                || ((MyThread)vm.elementAt(0)).isAlive());
        for (double d : a) {
            System.out.print(d + " ");
        }
        System.out.println(BasicFun.isSorted(a));
    }
}

