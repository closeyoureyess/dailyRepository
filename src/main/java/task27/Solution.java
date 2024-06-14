package task27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> fridayArrayList = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < fridayArrayList.size(); i++) {
            int entryAmount = Collections.frequency(fridayArrayList, val);
            int index = fridayArrayList.indexOf(val);
            if (entryAmount > 0) {
                fridayArrayList.remove(index);
            } else {
                break;
            }
        }
        return fridayArrayList.size();
    }
}