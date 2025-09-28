import java.util.HashMap;



class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. 트리 구성
        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++)
            parent.put(enroll[i], referral[i]);
        
        HashMap<String, Integer> totalAmount = new HashMap<>();
        
        // 2. 이익 분배
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            int money = amount[i] * 100;
            
            while (money > 0 && !curName.equals("-")) {
                totalAmount.put(curName, totalAmount.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);
                money /= 10;
            }
        }
        
        // 3. 반환값 배열 변환
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++)
            answer[i] = totalAmount.getOrDefault(enroll[i], 0);
        
        return answer;
    }
}