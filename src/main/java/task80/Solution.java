package task80;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int removeDuplicates(int[] nums) { // 1,1,2,2,2,2,3,3 // 1,1,1,2,2,3 // 0,0,1,1,1,1,2,3,3

        //Найти в массиве элементы, у которых нет дублей
        LinkedList<Integer> queueList = new LinkedList<>();
        for (int p = 0; p < nums.length; p++) {

            if (p != 0 && p != nums.length - 1 && nums[p] != nums[p + 1] && nums[p - 1] != nums[p]) { //Если не первый элемент и справа, и слева нет дублей
                queueList.add(nums[p]);
            }
            if (nums.length == 1) { // Если длина массива 1(1 элемент)
                queueList.add(nums[p]);

            } else if (p == nums.length - 1 && nums[p] != nums[p - 1]) { //Если больше 1, для последнего элемента
                queueList.add(nums[p]);
            }

        }

        //Подсчет кол-ва элементов в массиве в конце
        int enumerator = 0;
        for (int v = (nums.length - 1) - 1; v >= 0; v--) {
            if (nums[nums.length - 1] == nums[v]) {
                ++enumerator;
            } else {
                break;
            }
        }

        //Сортировка
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (int m = i + 1; m < nums.length; m++) {
                if (nums[i] == nums[m]) {
                    ++j;
                } else {
                    if (queueList.contains(nums[i]) && nums[i] == queueList.get(queueList.indexOf(nums[i])) && j > 0) { //Если попался элемент, который должен быть один в массиве
                        while (j > 0) {
                            nums[i + j] = nums[i + j + 1];
                            j--;
                        }
                        i = -1;
                    } else if (j > 1) { //Элемент, который дублируется более, чем 1 раз(напр. 2, 2, 2, хотя допустимо максимум 2, 2)
                        while (j > 1) {
                            nums[i + j] = nums[i + j + 1];
                            j--;
                        }
                        i = -1;
                    }
                    break;
                }
            }
        }

        //Подсчет кол-ва элементов в массиве
        int result = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] == nums[nums.length - 1]) {
                break;
            } else {
                result++;
            }
        }

        //
        if (enumerator >= 1) {
            k = result + 2;
        } else {
            k = result + 1;
        }

        return k;
    }
}
