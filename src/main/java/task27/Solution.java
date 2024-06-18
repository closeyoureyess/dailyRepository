/*
package task27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k++;
                //System.out.println("1: " + Arrays.toString(nums)); 0,1,2,2,3,0,4,2
            }
            else {
                nums[j++] = nums[i];
                //System.out.println("2: " + Arrays.toString(nums));
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - k;
    }
}*/
