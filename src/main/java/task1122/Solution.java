package task1122;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] abc = {1, 2, 3};

        ArrayList<Integer> arrayList1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> delElements = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        ArrayList<Integer> arrayList2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        delElements.removeAll(arrayList2);
        Collections.sort(delElements);
        System.out.println(delElements);

        arrayList1.removeAll(delElements);
        arrayList1.addAll(delElements);

        System.out.println(arrayList1);

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();


        for (int i = 0; i < arr2.length; i++) {
            hashMap1.put(i, arr2[i]);
        }

        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        ArrayList<Integer> needDelete = new ArrayList<>();

      /*  HashMap<Integer> arrayList1 = ArrayList.stream(arr1)
                .boxed()
                .collect(Collectors.toMap());*/

        /*ArrayList<Integer> arrayList2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));*/
        //Добавление одной коллекции в другую, теперь 2,3,1,3,2,4,6,7,9,2,19 +  2,1,4,3,9,6
        //arrayList2.addAll(arrayList1);                // 2, 3, 1, 3, 2, 4, 6, 9, 2, 7
        // 2, 2, 3, 1, 3, 4, 6, 9, 2, 7

        // С помощью add, перебрать элементы
        // Hashmap - сравнить элементы, убедиться, что у

       /* for (int i = 0; i < arrayList1.size(); i++) {
            int valArr1 = arrayList1.get(i);
            for (int j = 0; j < arrayList1.size(); j++){
                if(valArr1 == arrayList1.get(j)){
                    break;
                } else if () {
                    
                }
            }
        }*/
            /*int value1 = arrayList2.get(i);
            int k = i;
            System.out.println("i " + arrayList2.get(i));
            for (int j = i + 1; j < arrayList2.size(); j++) {
                if (value1 == arrayList2.get(j)) {
                    Collections.swap(arrayList2, k + 1, j);
                }
            }
        }*/

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < arrayList1.size() - delElements.size(); i++) { // 2,1,4,3,9,6
            if (arrayList1.get(i).equals(hashMap1.get(i))) {               // 2, 3, 1, 3, 2, 4, 6, 9, 2, 7
                //ищем, есть ли еще элементы-дубли  массиве
                for (int j = i + 1; j < arrayList1.size() - delElements.size(); i++) {
                    if (arrayList1.get(j).equals(arrayList1.get(i))) {
                        hashMap2.put(i + 1, arrayList1.get(j));
                        needDelete.add(j);
                        /*arrayList1.add(i + 1, arrayList1.get(j));
                        arrayList1.remove(j);*/
                    }
                }
            } else {

            }
        }


        return abc;
    }
}
