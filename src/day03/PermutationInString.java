package day03;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "ooolleoooleh";




        String c = "at";
        String big = "at";
        System.out.println(checkInclusion(c, big));



    }

    public static boolean checkInclusion(String s1, String s2){

        if (s1.length() == s2.length()) {
            return Arrays.equals(getCharCount(s1), getCharCount(s2));
        }
        // 记录s1的各个字符的个数
        int[] charCount = getCharCount(s1);

        // 滑动窗口的左右边界值：
        int left = 0;
        int right = s1.length() - 1;

        // 滑动窗口 左边的区间
        while (left < s2.length() - s1.length() ){

            while ( right < s2.length()) {
                // 获取窗口的字符
                String substring = s2.substring(left, right + 1);
                int[] targetCharCount = getCharCount(substring);
                // 比较
                if (Arrays.equals(targetCharCount, charCount)) {
                    return true;
                }else {
                    right++;
                    left ++;
                }
            }
        }

        return false;
    }

    public static int[] getCharCount(String targetString){

        int[] result = new int[26];
        char[] chars = targetString.toCharArray();
        for (char aChar : chars) {
            result[aChar - 'a']++;
        }

        return result;
    }
}
