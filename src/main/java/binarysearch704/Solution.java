package binarysearch704;

public class Solution {

    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int middle;
        int i = 0;

        while (first <= last) {
            middle = (first + last) / 2;
            if (target > nums[middle]) {
                first = middle + 1;
            } else if (target < nums[middle]) {
                last = middle - 1;
            }
            if (target == nums[middle]) {
                return middle;
            }
            i = 0;
            i++;
        }
        return -1;
    }

}


