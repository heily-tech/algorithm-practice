import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extCol = getColumn(ext);
        List<int[]> temp = new ArrayList<>();
        
        // 1. 비교군 뽑기
        for (int i = 0; i < data.length; i++)
            if (data[i][extCol] < val_ext) 
                temp.add(data[i]);
        
        // 2. 오름차순 정렬
        int sortCol = getColumn(sort_by);
        temp.sort((o1, o2) -> o1[sortCol] - o2[sortCol]);
        
        // 3. 리스트 -> 배열 변환
        int[][] answer = new int[temp.size()][4];
        for (int i = 0; i < temp.size(); i++)
            answer[i] = temp.get(i);
        
        return answer;
    }
    
    
    private int getColumn(String ext) {
        switch (ext) {
            case ("code"):
                return 0;
            case ("date"):
                return 1;
            case ("maximum"):
                return 2;
            case ("remain"):
                return 3;
        }
        return -1;
    }
}