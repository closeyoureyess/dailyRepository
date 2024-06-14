package task88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {

    private int counter = 0;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> arrayList1, arrayList2;

        arrayList1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(ArrayList::new));
        arrayList2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i < arrayList1.size(); i++){
            if(arrayList1.get(i) == 0){
                for (int j = 0 + counter; j < arrayList2.size(); j++){
                    arrayList1.set(i, arrayList2.get(j));
                    break;
                }
                counter++;
            }
        }
        Collections.sort(arrayList1);
        System.out.println(arrayList1);
    }
}

//Вам даны два целочисленных массива nums1 и nums2, отсортированных в порядке неубывания,
// и два целых числа m и n, представляющие количество элементов в nums1 и nums2 соответственно.
//
//Объедините nums1 и nums2 в один массив, отсортированный в порядке убывания.
//
//Конечный отсортированный массив не должен быть возвращен функцией,
// а должен храниться внутри массива nums1.

// Чтобы учесть это, nums1 имеет длину m + n, где первые m элементов обозначают элементы, которые должны быть объединены,
// а последние n элементов имеют значение 0 и должны игнорироваться. nums2 имеет длину n.