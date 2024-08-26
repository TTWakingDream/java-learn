package com.cl.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {


}


class ReverseList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add (T item){
        list.add(item);
    }


    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {

        int index;

        ReverseIterator(int i){
            index = i;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            return ReverseList.this.list.get(index);
        }
    }
}