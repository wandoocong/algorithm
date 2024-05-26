package str;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str = "DO geese see GOD?";
        boolean answer = isPalindrome(str);
        System.out.println("answer = " + answer);
        boolean answer2 = isPalindromeV2(str);
        System.out.println("answer2 = " + answer2);


    }

    public static boolean isPalindrome(String s){

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
            }

            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeV2(String s){

        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        return s_filtered.equals(s_reversed);
    }
}
