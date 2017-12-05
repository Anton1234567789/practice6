package ua.nure.sokolov.practice6.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    static List<Object> linkedList = new LinkedList<>();
    static List<Object> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        init(linkedList);
        init(arrayList);

        long start = System.currentTimeMillis();
        for (int j = 0; j < linkedList.size(); j++){
            remove(linkedList, 10);
        }
        long end = System.currentTimeMillis();
        System.out.println("times remove linkedList: " + (end - start));

        System.out.println("~~~~~~~~~~~~");

//        long start1 = System.currentTimeMillis();
//        for (int j = 0; j < arrayList.size(); j++){
//            arrayList.remove(j);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("times remove arrayList: " + (end1 - start1));


    }

    public static void remove(List<Object> list, int k){
        int countSize = 0;
        int count = 0;
        for (int j = list.size(); j > 0; j--) {
            if (list.size() == 1){
                break;
            }
            count = count + (k--);
//            while (count >= list.size)
//            }
        }
    }


    public static void init(List l){
        for (int j = 0; j < 50_000; j++){
            l.add("s");
        }
    }

}
