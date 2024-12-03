package findallnumbersdisappearedinanarray448;

import java.util.*;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int prevNumber = 0;
        int currentNumber;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            currentNumber = nums[i];
            if (nums.length == 1) {
                result.add(nums[i] + 1);
                break;
            }
            if (i != 0) {
                prevNumber = nums[i - 1]; // 4, 7  (7 - 4) - 1 = 2
            }
            if (i != nums.length - 1 && i != 0 && prevNumber + 1 != currentNumber ) {
                if (prevNumber != currentNumber) {
                    int localPrevNumber = prevNumber;
                    while (localPrevNumber != currentNumber) {
                        localPrevNumber += 1;
                        if (localPrevNumber != currentNumber) {
                            result.add(localPrevNumber);
                        }
                    }
                }
            } else if (i == nums.length - 1 && prevNumber == currentNumber) {
                result.add(currentNumber + 1);
            }
        }
        return result;
    }
}

// Учитывая массив nums из n целых чисел, где nums[i] находится в диапазоне [1, n], верните массив всех целых чисел
// в диапазоне [1, n], которые не отображаются в nums.