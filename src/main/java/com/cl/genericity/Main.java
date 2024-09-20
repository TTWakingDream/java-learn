package com.cl.genericity;

public class Main {

    public static void main(String[] args) {
        Pair<Integer, String> str = new Pair<>(1, "str");

    }

    public static void add(Pair<? extends Number, ? super String> pair) {
        Number value = new Integer(1);
//        pair.setFirst(value);
//        String s = new String("11");
//        pair.setSecond(s);;
//
//        Number first = pair.getFirst();
//        String second = pair.getSecond();

    }

}
class Pair<T, K> {
    private T first;
    private K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(K second) {
        this.second = second;
    }


    /**
     *
     * @param first
     * @param second
     * @return
     * @param <T>
     * @param <K>
     */
    public static <T,K> Pair<T, K> create(T first, K second){
        return new Pair<T, K>(first, second);
    }


}