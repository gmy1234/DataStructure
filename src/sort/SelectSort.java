package sort;

public class SelectSort {
    public static void main(String[] args) {
        // 选择排序
        int []arr = {-1,-4,3,0,10};

        SelectSort(arr);

        System.out.println(arr);
    }


    public static void SelectSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 最小数的下标
            int indexMin = i;
            for (int j = i; j < arr.length; j++) {
                // 比较 找出最小的值
                if (arr[indexMin] > arr[j]) {
                    // 找出最小的数的下标
                    indexMin = j;
                }
            }
            // 找到最小的下标了 进行交换
            int temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }

    }

}
