package findallnumbersdisappearedinanarray448;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    /*public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        int supCount = 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listMap = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (map.containsKey(nums[i])) {

            } else {
                if (nums[j] - nums[i] != 1 && nums[j] - nums[i] != 0) {
                    int count = nums[j] - nums[i];
                    while (supCount != count) {
                        listMap.add(nums[j] + supCount);
                        supCount++;
                    }
                } else {
                    j++;
                }
                map.put(nums[i], nums[i]);
            }
        }
        return List.of();
    }*/

    /*public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (nums[0] != 1 && nums.length == 1) {
            list.addFirst(1);
            list = list.subList(nums.length, list.size());
            return list;
        } else if (nums[0] != 1 && nums.length > 1) {
            list.addFirst(1);
            list = list.subList(nums.length, list.size());
        }
        int a;
        for (int i = 0; i < nums.length - 1; i++) {
            a = nums[i] + 1;
            if (!list.contains(a)) {
                while (!list.contains(a)) {
                    list.add(a);
                    a++;
                }
            }
        }
        list = list.subList(nums.length, list.size());
        return list;
    }*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        int a;
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            a = list.indexOf(nums[i]);
            if (a != -1) {
                list.remove(a);
            }
        }
        return list;
    }

}


/*Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.removeAll(Collections.singleton(nums[i]));
            }
        }
        return list;*/

/*  if (nums[nums.length - 1] == 1)
        list.add(2);
        for (int i = 1; i < nums[nums.length - 1]; i++) {
        list.add(i);
        }
list = list.stream()
                .filter(e -> Arrays.stream(nums).noneMatch(a -> a == e)) // Проверяем, что элемент не встречается в массиве
        .collect(Collectors.toList());
        return list;*/


/*Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, i);
        }
        List<Integer> list = new ArrayList<>();
        Collections.
    }*/
