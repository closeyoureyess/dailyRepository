package array1748;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public int sumOfUnique(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }

        //Перенос массива в hashmap, дабы удалить дубли
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(arrayList.get(i), arrayList.get(i));
        }

        //Проход по массиву, поиск значений, которые встречаются более 1 раза, удаление такого значения по ключу из HashMap

        for (int i = 0; i < arrayList.size(); i++) {
            int a = Collections.frequency(arrayList, arrayList.get(i));

            if (a > 1) {
                if (!hashMap.containsKey(arrayList.get(i))) {
                } else {
                    hashMap.remove(arrayList.get(i));
                }
            }

        }

        ArrayList<Integer> newArrayList = new ArrayList<>(hashMap.values());

        for (Integer i : newArrayList) {
            result += i;
        }
        return result;
    }
}
