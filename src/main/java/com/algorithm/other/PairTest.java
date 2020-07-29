package com.algorithm.other;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PairTest {
    public static void main(String[] args) {
        Pair<String, String> pair = new MutablePair<String, String>("aa","bb");
        System.out.println("left:" + pair.getLeft() + ",right:" + pair.getRight());
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        System.out.println(pair.toString());
        System.out.println(pair.toString());

        Pair<String, String>[] pairArr = new Pair[]{
                Pair.of("a","1"),
                Pair.of("b","2"),
                Pair.of("c","3")
        };
        int i = 1;
        for (Pair _pair : pairArr){
            System.out.println("----------- " + i + " -----------");
            System.out.println(_pair.getLeft());
            System.out.println(_pair.getRight());
            System.out.println(_pair.getValue());
            System.out.println(_pair.toString());
        }
    }
    
}
