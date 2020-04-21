public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String testCase = "bbb";
//        System.out.println(testCase.substring(6).equals(""));
        System.out.println(run(testCase));
    }

    public static Integer run(String str) {
        if (str.length() == 0 || str == null) return 0;
        if (str.length() ==1) return 1;
        int left = 0, right = 1;
        int count = 1;
        int result = 1;
        int position = 0;
        StringBuilder tmp = new StringBuilder();
        tmp.append(str.charAt(left));
        while (right < str.length()) {
            char charAtRight = str.charAt(right);
            String strAtRight = String.valueOf(charAtRight);
            String tmpString = tmp.toString();
            if(!tmpString.contains(strAtRight)) {
                count++;
                tmp.append(str.charAt(right));
                result = Math.max(tmp.length(), result);
            } else {
                position = tmpString.indexOf(strAtRight);
                tmp = new StringBuilder(tmp.toString().substring(position+1));
                tmp.append(strAtRight);
                count = 1;
                left++;
            }
            right++;
        }
        return result;
    }
}
