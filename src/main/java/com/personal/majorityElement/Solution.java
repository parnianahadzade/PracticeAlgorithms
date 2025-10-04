package com.personal.majorityElement;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,3};
        int[] num1 = new int[]{2,2,1,1,1,2,2};
        int[] num2 = new int[]{8,8,7,7,7};
        int[] num3 = new int[]{6,5,5};
        System.out.println(solution.majorityElement(nums));
        System.out.println(solution.majorityElement(num1));
        System.out.println(solution.majorityElement(num2));
        System.out.println(solution.majorityElement(num3));
    }

    public int majorityElement(int[] nums) {

        //o(n^2)
//        for (int i = 0; i < nums.length; i++) {
//            //counting itself
//            int count = 1;
//            for (int j = i + 1; j < nums.length; j++) {
//               if (nums[i] == nums[j]) {
//                   count++;
//               }
//            }
//
//            if (count > nums.length / 2) {
//                return nums[i];
//            }
//
//        }
//
//        return nums[0];


        //o(n) and space 1
        //Boyer–Moore logic
        int candidate = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count ++;
            }
            else {
                count--;
            }

        }

        return candidate;
    }
}
