import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            Stack<Character> st = new Stack<>();
            int cnt = 0;
            
            // 1. 110 패턴 찾기
            for (char ch : str.toCharArray()) {
                st.push(ch);
                if (st.size() >= 3) {
                    int p = st.size();
                    if (st.get(p-3) == '1'
                        && st.get(p-2) == '1'
                        && st.get(p-1) == '0') {
                        st.pop();
                        st.pop();
                        st.pop();
                        cnt++;
                    }
                }
            }
            
            // 2. 패턴 재삽입
            StringBuilder pattern = new StringBuilder();
            while (!st.isEmpty())
                pattern.append(st.pop());
            pattern.reverse();
            
            int insertPos = pattern.lastIndexOf("0") + 1;
            StringBuilder result = new StringBuilder(pattern);
            for (int j = 0; j < cnt; j++) {
                result.insert(insertPos, "110");
                insertPos += 3;
            }
            
            answer[i] = result.toString();
            
        }
        
        return answer;
    }
}