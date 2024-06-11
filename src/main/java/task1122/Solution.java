package task1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        ArrayList<Integer> arrayList1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> arrayList2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        //Добавление одной коллекции в другую, теперь 2,1,4,3,9,6 + 2,3,1,3,2,4,6,7,9,2,19
        arrayList2.addAll(arrayList1);

    }
}
