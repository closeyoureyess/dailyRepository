package task80;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int removeDuplicates(int[] nums) { // 0,0,1,1,1,1,2,3,3
        int j = 0;
        int counter = 0;
        int result = 0;
        int enumerator = 0;
        int k = 0;
        LinkedList<Integer> queueList = new LinkedList<>();

        for (int p = 0; p < nums.length; p++) {
            //Счетчик того, сколько дублей элемента в массиве, напр. 1 - 3
            if (p != 0 && p != nums.length - 1 && nums[p] != nums[p + 1] && nums[p - 1] != nums[p]) {
                queueList.push(nums[p]);
            }
            if (p == nums.length - 1 && nums[p] != nums[p - 1]) {
                queueList.push(nums[p]);
            }
        }

        for (int m = (nums.length - 1) - 1; m >= 0; m--) {
            if (nums[nums.length - 1] == nums[m]) {
                enumerator++;
            } else {
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                if (i != 0 && nums[i - 1] != nums[i]) {
                    j = 0;
                }
                j++;
            } else {
                if (i != nums.length - 1 && j == 2) {
                    if (!queueList.isEmpty() && queueList.contains(nums[i]) && nums[i] == queueList.get(queueList.indexOf(nums[i]))) {
                        int local = i;
                        nums[i] = nums[i + 1];
                        --j;
                        nums[--local] = nums[i];
                        //queueList.poll();
                        i = 0;
                    } else {
                        nums[i] = nums[i + 1];
                        counter++;
                        j = 0;
                    }
                } else if (i != nums.length - 1 && j > 2) {
                    int local = i;
                    if (!queueList.isEmpty() && queueList.contains(nums[i]) && nums[i] == queueList.get(queueList.indexOf(nums[i]))) {
                        while (j > 0) {
                            --j;
                            nums[--local] = nums[i];
                            //queueList.poll();
                        }
                        i = 0;
                    } else {
                        nums[i] = nums[i + 1];
                        while (j > 2) {
                            nums[--local] = nums[i];
                            j--;
                        }
                        j = 0;
                        i = 0;
                    }
                } else if (i != nums.length - 1 && j < 2 && counter > 0) {
                    nums[i] = nums[i + 1];
                } else if (!queueList.isEmpty()
                        && queueList.contains(nums[i])
                        && nums[i] == queueList.get(queueList.indexOf(nums[i]))
                        && i != nums.length - 1 && i != 0
                        && j < 2 &&
                        nums[i] == nums[i - 1] & nums[i] == nums[i + 1]) {
                    nums[i] = nums[i + 1];
                }
            }
        }

        for (int m = 0; m < nums.length; m++) {
            if (nums[m] == nums[nums.length - 1]) {
                break;
            } else {
                result++;
            }
        }

        if (result > 1) {
            k = result + 2;
        } else {
            k = result + 1;
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
