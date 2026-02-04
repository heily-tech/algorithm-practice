import java.io.IOException;
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
         Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target))
            return 0;

        List<String> allWords = new ArrayList<>(Arrays.asList(words));
        if (!wordSet.contains(begin))
            allWords.add(begin);

        int wordLength = begin.length();
        Map<String, List<String>> patternMap = getPatternMap(allWords, wordLength);


        return bfs(begin, target, patternMap, wordLength);
    }

    private static int bfs(String begin, String target, Map<String, List<String>> patternMap, int wordLength) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(begin);
        visited.add(begin);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(target))
                    return cnt;

                for (int j = 0; j < wordLength; j++) {
                    char[] chars = curr.toCharArray();
                    chars[j] = '*';
                    String pattern = new String(chars);

                    List<String> nb = patternMap.get(pattern);

                    if (nb == null || nb.isEmpty()) continue;;
                    for (String n : nb)
                        if (visited.add(n)) queue.offer(n);
                    nb.clear();
                }
            }
            cnt++;
        }
        return 0;
    }

    private static Map<String, List<String>> getPatternMap(List<String> allWords, int wordLength) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for (String word : allWords) {
            for (int i = 0; i < wordLength; i++) {
                char[] chars = word.toCharArray();
                chars[i] = '*';
                String pattern = new String(chars);

                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        return patternMap;
    }
}