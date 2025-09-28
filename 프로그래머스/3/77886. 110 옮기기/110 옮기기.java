import java.util.Arrays;

class Solution {
    public String[] solution(String[] s) {
        return Arrays.stream(s)
            .map(this::findPattern)
            .toArray(String[]::new);
    }
    
    private String findPattern(String s) {
        StringBuilder buffer = new StringBuilder();
        int cnt = 0;
        
        for (char ch : s.toCharArray()) {
            buffer.append(ch);
            int len = buffer.length();
            if (len >= 3 &&
               buffer.charAt(len - 3) == '1' &&
               buffer.charAt(len - 2) == '1' &&
               buffer.charAt(len - 1) == '0') {
                buffer.setLength(len - 3);
                cnt++;
            }
        }
        return insertPattern(buffer.toString(), cnt);
    }
    
    private String insertPattern(String s, int cnt) {
        int pos = s.lastIndexOf("0") + 1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < cnt; i++)
            sb.insert(pos, "110");
        
        return sb.toString();
    }
}
