import java.io.*;
import java.util.*;

public class Main {

    private static class Team {
        int id;
        List<Integer> scores = new ArrayList<>();
        int fourScore, fifth;

        Team(int id) {
            this.id = id;
        }

        void addScore(int score) {
            scores.add(score);
        }

        void calculate() {
            Collections.sort(scores);
            fourScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
            fifth = scores.get(4);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 팀 인원 세기
            Map<Integer, Integer> freq = new HashMap<>();
            int[] input = new int[N];
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                freq.put(input[i], freq.getOrDefault(input[i], 0) + 1);
            }

            // 유효팀만 생성
            Map<Integer, Team> teams = new HashMap<>();
            int score = 1;
            for (int teamId : input) {
                if (freq.get(teamId) < 6) continue; // 6명 미만 제외
                teams.computeIfAbsent(teamId, Team::new).addScore(score++);
            }

            // 유효팀 점수 계산
            List<Team> validTeams = new ArrayList<>(teams.values());
            for (Team team : validTeams) team.calculate();

            // 우승팀 찾기
            Team winner = validTeams.get(0);
            for (Team team : validTeams) {
                if (team.fourScore < winner.fourScore ||
                   (team.fourScore == winner.fourScore && team.fifth < winner.fifth)) {
                    winner = team;
                }
            }

            // 출력
            System.out.println(winner.id);
        }
    }
}
