package day02;

public class InsertSort {
    public static void main(String[] args) {
        System.out.println(5 / 2);


    }


    public static void SortInsert(int[] arr){
        // 分成有序的数组 和 无序的两部分。

        //  遍历无序数组
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i]; // 创建临时变量

            // 遍历有序的
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] > data){
                    arr[j + 1] = arr[j];
                }else {
                    break;
                }
            }
            arr[i + 1] = data;
        }

    }
}
