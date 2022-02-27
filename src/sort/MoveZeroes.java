package sort;

public class MoveZeroes {
    public static void main(String[] args) {

        // 暴力破解
        int []nums = {0,1,0,3,12};
        ViolentHacking2(nums);
        System.out.println(nums);



    }

    public static void ViolentHacking(int[] nums){
        int []arr =new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length ; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = arr[i];
        }
    }



    public static void ViolentHacking2(int[] nums){
        // 不用 new 新的数组
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length ; i++) {
            nums[i] = 0;
        }

    }
}
