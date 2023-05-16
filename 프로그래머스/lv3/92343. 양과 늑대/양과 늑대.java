import java.util.ArrayList;
import java.util.List;

class Solution {

    static int[][] infoGraph;
    static int answer = 0;

    public int solution(int[] info, int[][] edges) {

        infoGraph = new int[info.length][info.length];
        for (int i = 0; i < edges.length; i++) {
            infoGraph[edges[i][0]][edges[i][1]] = 1;
            infoGraph[edges[i][1]][edges[i][0]] = 1;
        }

        int[] routeSave = new int[info.length];
        routeSave[0] = 0;

        int[] check = new int[info.length];
        check[0] = 1;

        DFS(1, 0, 0, 0, info, routeSave, check);

        System.out.println(answer);
        return answer;
    }


    static List<Integer> findRoute(int start) {
        List<Integer> route = new ArrayList<>();

        for (int i = 0; i < infoGraph.length; i++) {
            if (infoGraph[start][i] == 1) {
                route.add(i);
            }
        }
        return route;
    }

    static void DFS(int value, int start, int sheep, int wolf, int[] info, int[] routeSave, int[] check) {


        if (info[start] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        } else {
            answer = Math.max(answer, sheep);
        }

        List<Integer> canMoveRoute = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            List<Integer> findRoute = findRoute(routeSave[i]);
            for (int x : findRoute) {
                if (check[x] != 1) {
                    canMoveRoute.add(x);
                }
            }
        }

        for (int x : canMoveRoute) {
            check[x] = 1;
            routeSave[value] = x;
            DFS(value + 1, x, sheep, wolf, info, routeSave, check);
            check[x] = 0;
        }
    }
}
