package missingnumber268;

import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int prevNumber = 0;
        int currentNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] != 0) {
                break;
            }
            if (i != 0) {
                prevNumber = nums[i - 1];
            }
            currentNumber = nums[i];
            if (i != 0 && prevNumber + 1 != currentNumber) {
                return prevNumber + 1;
            }
            if ((i != 0 && i == nums.length - 1 && prevNumber + 1 == currentNumber) || (nums.length == 1)) {
                return currentNumber + 1;
            }
        }
        return 0;
    }
}

//Учитывая массив nums, содержащий n различных чисел в диапазоне [0, n], верните единственное число в диапазоне,
// которое отсутствует в массиве.