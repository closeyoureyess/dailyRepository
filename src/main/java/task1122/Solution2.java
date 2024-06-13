package task1122;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

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

        LinkedList<Integer> linkedList3 = new LinkedList<>();

        delElements.removeAll(arrayList2);
        Collections.sort(delElements);
        System.out.println(delElements);

        arrayList1.removeAll(delElements);

        linkedList3.addAll(Collections.nCopies(arrayList1.size(), null));

        System.out.println("ArrayList1: " + arrayList1);

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();


        for (int i = 0; i < arrayList2.size(); i++) {
            hashMap1.put(arrayList2.get(i), i);
        }

        // 2,3,1,3,2,4,6,9,2
        // 2,1,4,3,9,6
        // 2 - 0, 1 - 1, 4 - 2, 3 - 3, 9 - 4, 6 - 5

        System.out.println("Hashmap: " + hashMap1.entrySet());

        //1.Проверить число
        //2.Сверить со вторым массивом
        //3.Если совпадает, проверить, есть ли дубли

        //1.Проверить число
        //2.Сверить со вторым массивом
        //3.Если не совпадает,

        int counter;
        int counterUnequal = 0;
        boolean cycle;
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println("i " + i);
            counter = 0;
            /*if (hashMap1.containsKey(i)) {*/
            if (linkedList3.get(hashMap1.get(arrayList1.get(i))) != null) {
                cycle = false;
                while (!cycle/*linkedList3.get(hashMap1.get(arrayList1.get(i)) + counter) != null*/) {
                    cycle = true;
                    //int value = linkedList3.get(hashMap1.get(arrayList1.get(i)) + counter);
                    int test = hashMap1.get(arrayList1.get(i)) + counter;
                    //System.out.println("Value " + value);
                    System.out.println("HashMap + index: " + test + counterUnequal);
                    if (linkedList3.get(hashMap1.get(arrayList1.get(i)) + counter) == null) { //Если ячейка занята и там не null, тогда
                        //Integer value2 = hashMap1.get(arrayList1.get(i)) + counter;
                        linkedList3.set(hashMap1.get(arrayList1.get(i)) + counter, arrayList1.get(i));
                        System.out.println("Add double linked list: " + linkedList3);
                        //if (value2.equals(arrayList1.get(i))) {}
                        int a = hashMap1.get(arrayList1.get(i));
                        System.out.println("Дополнительное условие1 " + a + " " + counter + " hren " + counterUnequal);
                        System.out.println("Дополнительное условие2 " + a + " ");
                        Collections.swap(linkedList3, hashMap1.get(arrayList1.get(i)) + (counterUnequal - 1), hashMap1.get(arrayList1.get(i)) + counter);
                        System.out.println("Дополнительное условие3: " + linkedList3);
                    } else {
                        if (linkedList3.get(hashMap1.get(arrayList1.get(i)) + counter).equals(arrayList1.get(i))) {
                            counterUnequal++;
                        }
                        counter++;
                        System.out.println("счетчик: " + counter);
                        cycle = false;
                    }
                }
            } else {
                Integer cKey = null;
                Integer key = null;
                int abcd;

                for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
                    cKey = entry.getKey();
                    if (cKey == i) {
                        key = cKey;
                    }
                }

                abcd = Collections.frequency(arrayList1, key);
                if (abcd > 1) {
                    for (int j = 0; j < abcd; j++) {
                        linkedList3.set(hashMap1.get(key) + j, arrayList1.get(i));
                        System.out.println("Add linked list: " + linkedList3);
                    }
                } else if (abcd == 1) {
                    linkedList3.set(hashMap1.get(key),
                }
            }
        }

        System.out.println("Modified linkedlist: " + linkedList3);
        return abc;
    }
}
