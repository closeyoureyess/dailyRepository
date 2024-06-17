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
                k++;
            }
        }

        return k;
    }
}

/*int number = nums[0];
        int numberIndex = 0;
        for (int k = 1; k < nums.length; k++){
            if(nums[k] != number){
                number = nums[k];
                numberIndex++;
                System.out.println(nums[k]);
            }
        }
        System.out.println(numberIndex);*/
