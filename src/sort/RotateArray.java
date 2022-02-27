package sort;

public class RotateArray {
    public static void main(String[] args) {
        // 轮转数组
        int []arr = {-4,-1,0,3,10};
        // 轮转次数
        int count = 10;

        int size = arr.length;

        /* 暴力解决*/
        // 创建 数组的索引
        int left = 0;
        int right = arr.length - 1;

        // 创建临时变量
        int temp;
        for(int i = 0 ; i < count; i++){
            temp = arr[right];
            for(int j = arr.length - 1 - 1; j >=0 ; j--){
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }


        System.out.println(arr);



        count %= size;
        // 第一次翻转数组
        reverse(0, size - 1, arr);
        reverse(0,count - 1,arr);
        reverse(count,size - 1,arr);

        System.out.println(arr);
    }

    public static void reverse(int left, int right, int []arr ){
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;


            left ++;
            right --;
        }
    }
}
