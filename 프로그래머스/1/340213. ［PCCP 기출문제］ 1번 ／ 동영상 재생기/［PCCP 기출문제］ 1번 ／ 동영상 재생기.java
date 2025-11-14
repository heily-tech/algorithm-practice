class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = toSec(video_len);
        int curr = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        
        curr = jump(curr, opStart, opEnd);
        
        for (String com : commands) {
            if (com.equals("next"))
                curr += 10;
            else
                curr -= 10;
        
            if (curr < 0)
                curr = 0;
            if (curr > video)
                curr = video;
            
            curr = jump(curr, opStart, opEnd);
        }
        
        return String.format("%02d:%02d", curr / 60, curr % 60);
    }
    
    private int toSec(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    private int jump(int pos, int start, int end) {
        return (pos >= start && pos <= end) ? end : pos;
    }
}