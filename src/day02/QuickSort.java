package day02;

import java.io.PrintStream;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 13, 5, 6, 2, 3, 7, 9, 5};

        quickSortIII(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的数放在数组的右边
     */
    public static void Category(int[] arr, int num) {
        int legnth = arr.length;
        // 指针
        int point = 0;
        // 左边界
        int leftBorder = -1;

        for (int i = 0; i < legnth; i++) {

            // 如果 point < num ，i和左边界的下一个元素做交换
            if (arr[point] < num) {
                leftBorder += 1;
                if (leftBorder > legnth) {
                    break;
                }
                swap(arr, i, leftBorder);
            }
            point++;
        }

    }

    /**
     * 给定一个数组arr，和一个数num，
     * 请把小于num的数放在数组的左边，等于num的放中间，大于num的数放在数组的右边
     *
     * @param arr 数组
     * @param num num
     */
    public static int[] flagOfNetherlands(int[] arr, int num) {
        // < 区域  = 区域   > 区域
        // 左边界，小于区域
        int leftBoard = -1;
        // 右边界，大于区域
        int rightBoard = arr.length;
        // 指针
        int point = 0;

        for (int i = 0; i < arr.length; i++) {

            /* 三种情况：
             * 1、 arr[point] < num
             * 2. arr[point] == num
             * 3. arr[point] > num */

            // 1.
            if (arr[point] < num) {
                // 左边界的下一个和 arr[point] 进行交换
                leftBoard += 1;
                swap(arr, leftBoard, point);
                point++;
            } else if (arr[point] == num) { // 2
                point++;
            } else { // 3
                // 右边界的左边和arr[point] 进行交换
                rightBoard -= 1;
                swap(arr, rightBoard, point);
            }
            if (rightBoard == point) {
                break;
            }

        }
        return new int[]{leftBoard, rightBoard};

    }

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0, 1 和 2 分别表示红色、白色和蓝色。
     *
     * @param nums 目标数组
     */
    public static void sortColors(int[] nums) {

        int leftBoard = -1;
        int rightBoard = nums.length;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[point] == 0) {
                leftBoard += 1;
                swap(nums, leftBoard, point);
                point++;

            } else if (nums[point] == 1) {
                point++;

            } else {
                rightBoard -= 1;
                swap(nums, rightBoard, point);
            }
            if (point == rightBoard) {
                break;
            }
        }


    }


    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    /**
     * 快速排序2.0 快拍用的就是 分区的思想
     *
     * @param arr 带排序的数组
     */
    public static void quickSortIII(int[] arr) {

        if (arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // TODO 时间复杂度提升为 O（N * logN）
            // swap(arr, l + (int) (Math.random() * (r - l + 1)), r);

            // 每次分区的基准数为最后一个。
            int[] p = flagOfNetherlands(arr, arr[r]);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[1], r);
        }
    }

}
