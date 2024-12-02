package task1122;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private int recurrence;

    private Integer pastValue;

    private int indx;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        ArrayList<Integer> arrayList1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> arrayList2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> delElements = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        LinkedList<Integer> linkedList = new LinkedList<>();

        //Удаление элементов второй статичной коллекции из копии первой коллекции, чтобы в коллекции остались только числа, которых нет во второй коллекции
        delElements.removeAll(arrayList2);
        Collections.sort(delElements);

        //Удаление чисел, которых нет во втором ArrayList, из оригинального первого списка
        arrayList1.removeAll(delElements);

        //Создание LinkedList, равного длине первого массива(минус уникальные числа), заполненного null-ами
        linkedList.addAll(Collections.nCopies(arrayList1.size(), null));

        //Создание и заполнение HashMap значениями из второго ArrayList, значение массива - key, индекс элемента массива - value
        LinkedHashMap<Integer, Integer> hashMap1 = new LinkedHashMap<>();
        for (int i = 0; i < arrayList2.size(); i++) {
            hashMap1.put(arrayList2.get(i), i);
        }

        for (int i = 0; i < arrayList1.size(); i++) {

            Integer cKey = null;
            Integer key = null;
            int counterMap = 0;

            for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
                cKey = entry.getKey();
                if (counterMap == i) {
                    key = cKey;
                    break;
                } else {
                    counterMap++;
                }
            }

            recurrence = Collections.frequency(arrayList1, key);

            if (i == 0) {
                if (recurrence > 1) {
                    for (int j = 0; j < recurrence; j++) {
                        linkedList.set(hashMap1.get(key) + j, key);
                    }
                } else if (recurrence == 1) {
                    linkedList.set(hashMap1.get(key), key);
                }
                // Сохраняем прошлое значение key
                pastValue = key;
            }

            indx = linkedList.lastIndexOf(pastValue);

            if (i > 0) {
                if (recurrence > 1) {
                    for (int k = 1; k <= recurrence; k++) {
                        linkedList.set(indx + k, key);
                    }
                } else if (recurrence == 1) {
                    if (indx + 1 == arrayList1.size()) {
                        linkedList.set(indx, key);
                    } else {
                        linkedList.set(indx + 1, key);
                    }
                }
                //Сохраняем прошлое значение key
                pastValue = key;
            }
        }

        //Склейка не входивших во второй массив сортированных элементов с концом основного списка
        linkedList.addAll(delElements);
        //Преобразование списка в примитивный массив типа int
        int[] result = linkedList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}


