import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. ArrayList를 활용하여 동적 할당
        ArrayList<Element> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(new Element(Integer.parseInt(br.readLine()), i));  // 동적 할당
        }

        // 3. 정렬 수행 (값 기준 오름차순 정렬)
        Collections.sort(list);

        // 4. 최대 이동 거리 계산 (원래 index와 정렬 후 index 비교)
        int maxShift = 0;
        for (int i = 0; i < N; i++) {
            maxShift = Math.max(maxShift, list.get(i).index - i);
        }

        // 5. 결과 출력
        System.out.println(maxShift + 1);
    }

    // Element 클래스 (Comparable 인터페이스 구현)
    static class Element implements Comparable<Element> {
        int value, index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
