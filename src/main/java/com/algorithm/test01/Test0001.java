package com.algorithm.test01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by h on 2018/11/27.
 */
public class Test0001 {

    /**
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     */

    public static void main(String[] args) {
        //twoSum(new int[]{1,2,3,4,5,6,7,8,9}, 10);
        int[] numbers = new int[]{2,3,4,5,6,7,8};
        int target = 10;
        int[] a = twoSum3(numbers, target);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void twoSum(int[] nums, int target) {
        int firstOneSize = 0;

        for (int firstOne : nums) {

            int secondOneSize = 0;

            for (int secondOne : nums) {
                if (secondOneSize != firstOneSize) {
                    if (firstOne + secondOne == target) {
                        System.out.println(firstOne + "," + firstOneSize + "," + secondOne + "," + secondOneSize);
                    }
                }
                secondOneSize ++;
            }
            firstOneSize ++;
        }
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
