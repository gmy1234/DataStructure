package sort;

public class TwoSum {
    public static void main(String[] args) {
        /**
         *         输入：numbers = [2,7,11,15], target = 9
         *         输出：[1,2]
         *         解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
         */

        // 该数组已按 递增顺序排列
        int[] arr = {2,7,11,15};
        int target = 9;

        // 双指针 法
        int left = 0;

        int []result =  new int[2];
        for (left = 0; left < arr.length - 1; left++) {

            for (int right = 1 + left ; right < arr.length ; right++) {
                int data = arr[left] + arr[right];
                if (data == target && left != right) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    System.out.println(result[0] + " " + result[1]);
                }
            }

        }
    }
}
