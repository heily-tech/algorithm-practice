import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String[] groups = s.substring(2, s.length() - 2).split("\\},\\{");

        Map<Integer, Integer> freq = new HashMap<>(); // 숫자, 빈도
        for (String gr : groups) {
            Arrays.stream(gr.split(","))
                  .map(Integer::parseInt)
                  .forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));
        }
        
        return freq.entrySet().stream()
                   .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
                   .map(Map.Entry::getKey)
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}
