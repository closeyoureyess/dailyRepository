package task88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {

    private int counter = 0;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length; i++){
            if(nums1[i] == 0){
                for (int j = 0 + counter; j < nums2.length; j++){
                    nums1[i] = nums2[j];
                    break;
                }
                counter++;
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}