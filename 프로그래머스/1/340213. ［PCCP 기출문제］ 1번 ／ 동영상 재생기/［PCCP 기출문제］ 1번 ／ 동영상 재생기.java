class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = toSec(video_len);
        int curr = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        curr = jump(curr, opStart, opEnd);

        for (String com : commands) {
            curr += com.equals("next") ? 10 : -10; 

            curr = clamp(curr, 0, video);         
            curr = jump(curr, opStart, opEnd);    
        }

        return String.format("%02d:%02d", curr / 60, curr % 60);
    }

    private int toSec(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private int clamp(int x, int min, int max) {
        return Math.max(min, Math.min(max, x));
    }

    private int jump(int pos, int start, int end) {
        return (pos >= start && pos <= end) ? end : pos;
    }
}
