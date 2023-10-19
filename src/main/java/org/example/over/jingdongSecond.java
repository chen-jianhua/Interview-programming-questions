package org.example.over;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jingdongSecond {
    //一、 给你一个由n个整数组成的数组nums，和一个目标值target。请你找出并返回满足下述全部条件且不重复的四元组
    // [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
    //0 <= a, b, c, d< n
    //a、b、c和d互不相同
    //nums[a] + nums[b] + nums[c] + nums[d] == target
    //你可以按任意顺序返回答案 。
    //
    //示例 1：
    //输入：nums = [1,0,-1,0,-2,2], target = 0
    // 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        //第一个数
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //相等就跳过这一次
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                //最小的四个之和都大于target说明不可能，退出循环
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                //加上最大的三个还是小于target，说明这个不可能了
                continue;
            }
            //第二个数
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //相等就跳过这一次
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    //最小的四个之和都大于target说明不可能，退出循环
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    //加上最大的三个还是小于target，说明这个不可能了
                    continue;
                }
                //剩余两个数用双指针遍历的方式
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            //跳过左边相等的
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            ////跳过右边相等的
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        //不等于target，小于说明要更大的值，所以left右移
                        left++;
                    } else {
                        //大于说明要更小的值，所以right左移
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}

