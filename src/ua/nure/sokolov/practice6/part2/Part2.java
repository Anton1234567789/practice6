package ua.nure.sokolov.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    static List<Object> linkedList = new LinkedList<>();
    static List<Object> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        init(linkedList);
        init(arrayList);

//        long start = System.currentTimeMillis();
//        for (int j = 0; j < linkedList.size(); j++){
//            remove(linkedList, 4);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("times remove linkedList: " + (end - start));
//
//        System.out.println("~~~~~~~~~~~~");
//
//        long start1 = System.currentTimeMillis();
//        for (int j = 0; j < arrayList.size(); j++){
//            remove(arrayList, 4);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("times remove arrayList: " + (end1 - start1));

        System.out.println("~~~~~~~~~~~~");

        long start2 = System.currentTimeMillis();
        for (int j = 0; j < arrayList.size(); j++){
            removeUsedIterator(arrayList);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("times remove with iter arrayList: " + (end2 - start2));

        System.out.println("~~~~~~~~~~~~");

        long start3 = System.currentTimeMillis();
        for (int j = 0; j < linkedList.size(); j++){
            removeUsedIterator(linkedList);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("times remove with iter linkedList: " + (end3 - start3));



    }

    public static void remove(List<Object> list, int k){
        int count = 0;
        int countSize = 0;
        for (int j = 0; j < list.size(); j++){
            if (list.size() == 1){
                break;
            }
            count = count + (k);
            list.remove(count);
            j += count;
        }
    }

    public static void removeUsedIterator(List<Object> list){
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){

            if (list.size() == 1){
                break;
            }
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
            }
            if (iterator.hasNext()) {
                iterator.next();
            }
            iterator.remove();
        }

    }



    public static void init(List l){
        int n = 0;
        for (int j = 0; j < 100_000; j++){
            l.add("s"+n);
            n++;
        }
    }

}
