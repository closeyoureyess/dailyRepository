package task26;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) { //0,0,1,1,1,2,2,3,3,4

        int k = 0;
        int index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
            } else {
                nums[index2++] = nums[i];
                System.out.println("ind " + index2 + " 4islo " + nums[index2]);
                System.out.println(i);
                System.out.println(Arrays.toString(nums));
                k++;
            }
        }

        return k;
    }
}
