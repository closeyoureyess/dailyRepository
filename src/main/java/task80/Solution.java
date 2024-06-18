package task80;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) { // 0,0,1,1,1,1,2,3,3
        int j = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                j++;
            } else {
                if (j >= 2) {
                    nums[i] = nums[i + 1];
                    k++;
                    j = 0;
                } else if (j < 2 && k > 0) {
                    nums[i] = nums[i + 1];
                    k = 0;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
    //System.out.println(Arrays.toString(nums));
}
