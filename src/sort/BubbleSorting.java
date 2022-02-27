package sort;

public class BubbleSorting {
    public static void main(String[] args) {
        //  冒泡排序
        int []nums = {-4,-1,0,3,10};
        int temp = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[l++] = nums[i] * nums[i];
        }
        for (int n = 0; n < nums.length; n++) {
            for (int m = 0; m < nums.length - n - 1; m++) {
                if (nums[m] > nums[m+1]){
                    temp = nums[m];
                    nums[m] = nums[m+1];
                    nums[m+1] = temp;
                }
            }
        }

        for (int q = 0; q < nums.length; q++) {
            System.out.println(nums[q]);

        }
    }
}
