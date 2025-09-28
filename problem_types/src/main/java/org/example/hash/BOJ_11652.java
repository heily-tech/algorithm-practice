package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 31468KB
 * 시간 296ms
 */

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        Map<Long, Integer> cards = new HashMap<>(); // 카드의 숫자, 카드의 빈도
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());
            cards.merge(number, 1, Integer::sum);
        }

        // 2. 최대 빈도수 구하기
        int maxFreq = 0;
        long mostFreqCard = 0;
        for (Map.Entry<Long, Integer> entry : cards.entrySet()) {
            long card = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFreq) {
                maxFreq = frequency;
                mostFreqCard = card;
            } else if (frequency == maxFreq && card < mostFreqCard) {
                mostFreqCard = card;
            }
        }

        // 3. 결과 출력
        System.out.println(mostFreqCard);
    }
}
