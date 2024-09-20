package com.cl.genericity;

import java.lang.reflect.Constructor;

public class GenericDemo {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        // 反射API就是泛型
        // compile warning
        Class clazz = String.class;
        String s = (String) clazz.newInstance();
        // no warning
        Class<String> stringClass = String.class;
        String s1 = stringClass.newInstance();

//    调用Class的getSuperclass()方法返回的class类型是Class<? super T>
        Class<? super String> superclass = String.class.getSuperclass();
//    构造方法Constructor<T>也是泛型
        Class<Integer> integerClass = Integer.class;
        Constructor<Integer> constructor = integerClass.getConstructor(int.class);

        // 可以声明代泛型的数组，但是不能用new操作符创建带泛型的数组：
//        Pair<String, Integer> [] pairs = new Pair<String,Integer>[10]; // 编译错误
        Pair<String, Integer> [] pairs = null;

        @SuppressWarnings("uncheck")
        Pair<String, Integer>[] pairs1 = (Pair<String, Integer>[]) new Pair[2];


        //
        //使用泛型数组要特别小心，因为数组在运行期没有泛型，编译器可以强制检查变量ps，因为它的类型是泛型数组；但是编译器不会检查变量arr；因为它不是泛型数组。因为这两个变量实际上指向同一个数组，所以操作arr可能导致从ps获取元素报错；
        // 例如如下代码演示了不安全的使用泛型数组；
        Pair[] arr = new Pair[2];
        Pair<String, Integer>[] ps = (Pair<String, Integer>[]) arr;
        ps[0] = new Pair<String, Integer>("1", 1);
        arr[1] = new Pair<String, String>("1", "1");


    }

}
