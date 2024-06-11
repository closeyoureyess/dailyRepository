package task1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] abc = {1, 2, 3};

        ArrayList<Integer> arrayList1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> arrayList2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> arrayList2dub = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        //Добавление одной коллекции в другую, теперь 2,1,4,3,9,6 + 2,3,1,3,2,4,6,7,9,2,19
        arrayList2.addAll(arrayList1);                // 2,1,4,3,9,6,2,2,2

        Iterator<Integer> iterator = arrayList2.iterator();

        for (int i = 0; i < arrayList2.size(); i++) {
            int value1 = arrayList2.get(i);
            int k = i;
            System.out.println("i " + arrayList2.get(i));
            for (int j = i + 1; j < arrayList2.size(); j++) {
                if (value1 == arrayList2.get(j)) {
                    Collections.swap(arrayList2, k + 1, j);
                }
            }
        }
        System.out.println("Result " + arrayList2);
        return abc;
    }
}
