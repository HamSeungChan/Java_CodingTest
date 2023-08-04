import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Client> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Client(i, Integer.parseInt(token.nextToken()), token.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Client client = queue.poll();
            sb.append(client.age).append(" ").append(client.name).append("\n");
        }
        System.out.print(sb);
    }
}

class Client implements Comparable<Client> {
    int i;
    int age;
    String name;

    public Client(int i, int age, String name) {
        this.i = i;
        this.age = age;
        this.name = name;

    }

    @Override
    public int compareTo(Client o) {

        if (this.age == o.age) {
            return this.i - o.i;
        }
        return this.age - o.age;
    }
}