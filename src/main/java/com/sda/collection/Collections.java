package com.sda.collection;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //collectionPriorityQueue();
        collectionMap();





    }

    private static void collectionPriorityQueue() {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        System.out.println(queue);
        String peek = queue.peek();
        System.out.println(peek);
        queue.remove();

        System.out.println(queue);

    }

    private static void collectionMap(){

        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("dziedziczenie", "Jest to mechanizm...");
        dictionary.put("wkretarka", "Jest to urządzenie do ...");
        Set<String> set = dictionary.keySet();
        Collection<String> values = dictionary.values();

        System.out.println(set);
        System.out.println(values);
        String wkretarka = dictionary.get("wkretarka");
        System.out.println(wkretarka);


    }


}
