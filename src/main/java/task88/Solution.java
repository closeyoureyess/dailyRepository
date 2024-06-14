package task88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {

    private int counter = 0;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length; i++){
            if(nums1[i] == 0){
                for (int j = 0 + counter; j < nums2.length; j++){
                    nums1[i] = nums2[j];
                    break;
                }
                counter++;
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
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