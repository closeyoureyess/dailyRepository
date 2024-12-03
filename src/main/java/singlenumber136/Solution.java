package singlenumber136;

import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int prevNumber = 0;
        int currentNumber = 0;
        int dupl = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                prevNumber = nums[i - 1];
            }
            currentNumber = nums[i];
            if (i != 0 && prevNumber == currentNumber) {
                dupl++;
            }
            if (i != 0 && dupl > 0 && prevNumber != currentNumber) {
                dupl = 0;
            } else if (i != 0 && dupl == 0 && prevNumber != currentNumber) {
                return prevNumber;
            } else if (i != 0 && i == nums.length - 1 && dupl > 0 && prevNumber == currentNumber) {
                currentNumber = 403;
            }
        }
        return currentNumber;
    }
}

// Учитывая непустой массив целых чисел nums, каждый элемент появляется дважды, за исключением одного.
// Найдите этот единственный элемент.
//
//Необходимо реализовать решение с линейной сложностью во время выполнения и использовать только постоянное
// дополнительное пространство.