package org.ankur.ds;

public class MinHeap {
    private int[] heap;
    private int index;
    private int size;

    public MinHeap(int size){
        this.size =size;
        this.index=0;
        heap = new int[size];
    }
}
