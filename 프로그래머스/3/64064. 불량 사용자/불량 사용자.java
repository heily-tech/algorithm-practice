import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        // 가능한 조합을 담는 집합 선언
        Set<Set<String>> result = new HashSet<>();
        dfs(user_id, banned_id, 0, new HashSet<>(), result);
        
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int index, Set<String> chosen, Set<Set<String>> result) {
        if (index == banned_id.length) {
            result.add(new HashSet<>(chosen)); // copy
            
            return;
        }
        
        String regex = banned_id[index].replace("*", ".");
        for (String user : user_id) {
            if (chosen.contains(user))
                continue;
            if (user.length() != banned_id[index].length())
                continue;
            
            if (Pattern.matches(regex, user)) {
                chosen.add(user);
                dfs(user_id, banned_id, index+1, chosen, result);
                chosen.remove(user); // backtracking
            }
        }
    }
}