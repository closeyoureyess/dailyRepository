package containsduplicate217;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Integer value;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            value = nums[i];
            if (map.isEmpty()) {
                pointer++;
                map.put(value, value);
            }
            if (map != null && pointer == 0) {
                boolean boolValue = map.containsKey(value);
                if (boolValue) {
                    return true;
                }
                map.put(value, value);
            }
            pointer = 0;
        }
        return false;
    }
}

//Учитывая целочисленный массив nums, верните true, если какое-либо значение появляется в массиве по крайней мере дважды,
// и верните false, если каждый элемент различен.