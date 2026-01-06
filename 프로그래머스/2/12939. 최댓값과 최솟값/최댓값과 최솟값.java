class Solution {
    public String solution(String s) {
        if (s == null || s.trim().isEmpty())
            throw new IllegalArgumentException("입력이 비어 있습니다.");

        String[] strs = s.trim().split("\\s+");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : strs) {
            int num;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + str);
            }

            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        return min + " " + max;
    }
}