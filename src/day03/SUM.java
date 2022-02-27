package day03;

import java.util.ArrayList;
import java.util.Arrays;

public class SUM {
    public static void main(String[] args) {

        int[] c =  {3, 2, 4};
        int t = 6;
        System.out.println(Arrays.toString(twoSum(c, t)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        ArrayList<Integer> data = new ArrayList<>();

        for (int lef = 0; lef < nums.length; lef++) {

            for (int rig = lef; rig < nums.length; rig++) {
                if (nums[lef] + nums[rig] == target && lef != rig) {
                    result[0] = lef;
                    result[1] = rig;
                    return result;
                }

            }
        }


        return result;
    }
}
