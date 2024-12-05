package findallnumbersdisappearedinanarray448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int prevNumber = 0;
        int currentNumber;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        if (nums[0] != 1) {
            result.add(1);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            currentNumber = nums[i];
            if (nums.length == 1) {
                result.add(nums[i] + 1);
                break;
            }
            if (i != 0) {
                prevNumber = nums[i - 1]; // 4, 7  (7 - 4) - 1 = 2
            }
            if (prevNumber == currentNumber) {
                count++;
            }
            if (nums.length % 2 == 0 && i == nums.length - 1 && prevNumber == currentNumber) {
                if (count > 0) {
                    if (nums.length == 2) {
                        result.add(nums[i] + 1);
                        break;
                    }
                    if (nums.length >= 4) {
                        if(nums[i - 3] == nums[i - 2]) {
                            while (count + 1 > 0) {
                                currentNumber++;
                                result.add(currentNumber);
                                count--;
                            }
                        } else {
                            while (count > 0) {
                                currentNumber++;
                                result.add(currentNumber);
                                count--;
                            }
                        }
                    }
                } else {
                    result.add(currentNumber + 1);
                }
            } else if(i != 0 && prevNumber + 1 != currentNumber) {
                if (prevNumber != currentNumber) {
                    while (prevNumber != currentNumber) {
                        prevNumber += 1;
                        if (prevNumber != currentNumber) {
                            result.add(prevNumber);
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        return result;
    }
}

// Учитывая массив nums из n целых чисел, где nums[i] находится в диапазоне [1, n], верните массив всех целых чисел
// в диапазоне [1, n], которые не отображаются в nums.