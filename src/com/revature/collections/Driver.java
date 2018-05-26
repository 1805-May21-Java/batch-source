package com.revature.collections;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args){
        //LinkedHashSet has no duplicates and maintains order of insertion.
        LinkedHashSet<Integer> hset = new LinkedHashSet<>();
        hset.add(6);
        hset.add(1);
        hset.add(2);
        hset.add(9);
        hset.add(2);
        System.out.println(hset);

        //treeSet
        TreeSet<Integer> tSet = new TreeSet<Integer>();

        tSet.add(6);
        tSet.add(1);
        tSet.add(2);
        tSet.add(9);
        tSet.add(2);

        System.out.println(tSet);

        System.out.println("+++++++++++++++++++++++++++");

        LinkedHashSet<ChineseFood> foodSet = new LinkedHashSet<>();

        foodSet.add(new ChineseFood(80, "Tsos", true));
        foodSet.add(new ChineseFood(20, "Fortune", false));
        foodSet.add(new ChineseFood(155, "Dumbplings", true));
        for (ChineseFood f:foodSet) {
            System.out.print(f);
        }
        System.out.println();

        TreeSet<ChineseFood> fooTreedSet = new TreeSet<>();

        System.out.println("--------------------------");
        fooTreedSet.add(new ChineseFood(155, "Dumbplings", true));
        fooTreedSet.add(new ChineseFood(20, "Fortune", false));
        fooTreedSet.add(new ChineseFood(80, "Tsos", true));
        for (ChineseFood f:fooTreedSet) {
            System.out.print(f);
        }
        System.out.println("\n--------------------------");

        LinkedList<ChineseFood> foodList = new LinkedList<>();

        System.out.println("--------------------------");
        foodList.add(new ChineseFood(155, "Dumbplings", true));
        foodList.add(new ChineseFood(20, "Fortune", false));
        foodList.add(new ChineseFood(80, "Tsos", true));
        System.out.print("\nBefore using utility class method.\n");
        for (ChineseFood f:fooTreedSet) {
            System.out.print(f);
        }
        
        System.out.print("\n\nAfter using utility class method.\n");
        Collections.sort(foodList, new ComparePrice());
        System.out.print(foodList);
        System.out.println("\n--------------------------");
    }
}
