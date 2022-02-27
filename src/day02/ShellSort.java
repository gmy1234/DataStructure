package day02;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
      int[] arr = {49  , 38  , 65  , 97  , 26 ,  13 ,  27 ,  49  , 55 ,  4};

        // 使用逐步推导法 来搞一搞
        shellSortPlus(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 移位法
     * @param arr 数组
     */
    public static void shellSort(int[] arr){
        // 步长改变的循环。
        for (int gap = arr.length / 2 ; gap > 0 ; gap /= 2)
            // 将数组 一 gap 为 分组
            for (int i = gap; i < arr.length; i++)
                // 遍历每个组中的所有元素，
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    int temp;
                    // 每组的元素 前一个比后一个大，就交换
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp ;
                    }
                }

    }


    /**
     * 移位法
     * @param arr 数组
     */
    public static void shellSortPlus(int[] arr){
        // 步长改变的循环。
        for (int gap = arr.length / 2 ; gap > 0 ; gap /= 2)
            // 从第 gap 个元素， 逐个对齐所在的组进行 插入排序
            for (int i = gap ; i < arr.length; i++) {

                // 用来记录待插入的位置
                int minIndex = i;
                // 临时变量
                int temp = arr[minIndex];
                // 前边的比后边小
                if (arr[minIndex] < arr[minIndex - gap]){ // 每个元素与自己组内的数据进行直接插入排序

                    while ( minIndex - gap >= 0 && temp < arr[minIndex - gap]){
                        // 移动
                        arr[minIndex] = arr[minIndex - gap];
                        minIndex -= gap;
                    }
                    // 退出循环，找到位置了
                    arr[minIndex] = temp;
                }
            }



    }
}
