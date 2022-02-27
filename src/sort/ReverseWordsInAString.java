package sort;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String[] str = s.split(" ");
        int left = 0;
        int right = 0;

        StringBuffer buffer = new StringBuffer();
        for (String word : str) {
            int len = word.length();
            char[] wordArr = word.toCharArray();

            reverse(left, len - 1, wordArr);
            buffer.append(wordArr);
            buffer.append(" ");
            System.out.println(wordArr);

//            buffer.append(new StringBuffer(word).reverse().toString());
//            System.out.println(buffer);

        }
        System.out.println(buffer.toString().trim());


    }

    public static void reverse(int left, int right, char []arr ){
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }
    }
}
