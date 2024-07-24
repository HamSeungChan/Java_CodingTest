import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            token = new StringTokenizer(br.readLine(), " ");

            // 팀의 갯수
            int n = Integer.parseInt(token.nextToken());
            // 문제의 개수
            int k = Integer.parseInt(token.nextToken());
            // 팀의 ID
            int t = Integer.parseInt(token.nextToken());
            // 로그 엔트리의 개수
            int m = Integer.parseInt(token.nextToken());

            List<TeamInfo> teamInfoList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                teamInfoList.add(new TeamInfo(i));
            }

            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int teamId = Integer.parseInt(token.nextToken());
                int problem = Integer.parseInt(token.nextToken());
                int score = Integer.parseInt(token.nextToken());

                TeamInfo teamInfo = teamInfoList.get(teamId - 1);
                teamInfo.submitCount++;
                teamInfo.lastTime = i;
                Map<Integer, Integer> problems = teamInfo.problem;

                if (!problems.containsKey(problem)) {
                    problems.put(problem, score);
                    teamInfo.totalScore += score;
                    continue;
                }

                if (problems.get(problem) < score) {
                    teamInfo.totalScore += score - problems.get(problem);
                    problems.put(problem, score);
                }
            }

            Collections.sort(teamInfoList);
            int answer = 1;
            for (TeamInfo teamInfo : teamInfoList) {
                if (teamInfo.teamId == t) {
                    sb.append(answer).append("\n");
                    break;
                }
                answer++;
            }
        }
        System.out.print(sb);
    }
}

class TeamInfo implements Comparable<TeamInfo> {

    int teamId;
    int totalScore;
    int submitCount;
    int lastTime;
    Map<Integer, Integer> problem = new HashMap<>();

    public TeamInfo(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public int compareTo(TeamInfo o) {
        if (o.totalScore == this.totalScore) {
            if (submitCount == o.submitCount) {
                return this.lastTime - o.lastTime;
            }
            return this.submitCount - o.submitCount;
        }
        return o.totalScore - this.totalScore;
    }
}