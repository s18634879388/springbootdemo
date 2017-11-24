package com.test;

import java.util.function.IntFunction;

/**
 * Created by Administrator on 2017/11/23.
 */
public class Java8 {
    public static Apple instance(IntFunction<Apple> appleIntFunction){
        return appleIntFunction.apply(10);
    }

    public static void main(String[] args) {
        Apple apple = instance(Apple::new);
        System.out.println(apple.getWeight());
        System.out.println();

    }
}


class Apple{
    public Apple(){}
    private int weight;
    public Apple(int weight){
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
