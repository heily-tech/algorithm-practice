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
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                order.add(team);
                freq.put(team, freq.getOrDefault(team, 0) + 1);
            }

            // 유효팀만 생성
            Map<Integer, Team> teams = new HashMap<>();
            int score = 1;
            for (int teamId : order) {
                if (freq.get(teamId) < 6) 
                    continue;
                teams.computeIfAbsent(teamId, Team::new).addScore(score++);
            }

            // 유효팀 점수 계산
            Team winner = null;
            for (Team team : teams.values()) {
                team.calculate();
                if (winner == null ||
                    team.fourScore < winner.fourScore ||
                    (team.fourScore == winner.fourScore && team.fifth < winner.fifth)) {
                    winner = team;
                }
            }

            // 출력
            System.out.println(winner.id);
        }
    }
}
