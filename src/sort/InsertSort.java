package sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 4, 10};
        int k = 0;

        int[] ints = sortedSquares(nums, 5);
        System.out.println(ints);
//        for( int i = 0 ; i < nums.length ; i ++){
//            nums[k++] = nums[i] * nums[i];
//        }
        int length = nums.length;
        // 1、默认第一个元素有序。所以从第二个开始遍历 ，依次插入有序序列,既遍历无序数组
        for (int orderly = 1; orderly < length; orderly++) {
            int dis = 0;
            int temp = nums[orderly];  // 取出第i个数，和前i-1个数比较后，插入合适位置

            // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数 (nums[j]) 比 temp大，就把这个数后移一位

            // 拿到这个 无序的元素后  为这个元素在有序数 [0,1,... , i - 1 ]区间 找一个合适的位置, 在这个区间从后往前遍历
            for (dis = orderly - 1; dis >= 0; dis--) {
                if (temp < nums[dis])
                    nums[dis + 1] = nums[dis];
                else
                    break;
            }
            nums[dis + 1] = temp;
            // Orderly 有序的
        }


    }

    public static int[] sortedSquares(int[] arr, int length) {
       //双指针
        int left = 0 ;
        int right = length - 1;
        int post = right;
        int []temp = new int[length];
        for (left = 0 ,right = length - 1, post = length - 1; left <= right;){
            if (arr[left] * arr[left] > arr[right] * arr[right]){
                temp[post] = arr[left] * arr[left];
                ++left ;
            }else {
                temp[post] = arr[right] * arr[right];
                --right ;
            }
            --post;
        }
        return temp;
    }
}
