import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int people;
    static int personA;
    static int personB;
    static int graph[][];
    static int nodeCheck[];
    static int relationCount = -1;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        people = sc.nextInt();
        graph = new int[people + 1][people + 1];
        nodeCheck = new int[people + 1];

        personA = sc.nextInt();
        personB = sc.nextInt();
        int numberOfRelation = sc.nextInt();

        int parents, child = 0;

        for (int i = 0; i < numberOfRelation; i++) {
            parents = sc.nextInt();
            child = sc.nextInt();
            graph[parents][child] = 1;
            graph[child][parents] = 1;
        }

        nodeCheck[personA] = 1;
        new Main().DFS(personA);

        System.out.println(relationCount);
    }

    public void DFS(int n) {
        if (n == personB) {
            relationCount = (int)Arrays.stream(nodeCheck)
                    .filter(i -> i == 1 )
                    .count() - 1;
            return;
        } else {
            for (int i = 1; i <= people; i++) {
                if (graph[n][i] == 1 && nodeCheck[i] == 0) {
                    nodeCheck[i] = 1;
                    DFS(i);
                    nodeCheck[i] = 0;
                }
            }
        }
    }

}
