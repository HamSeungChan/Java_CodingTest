import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();
        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int quality = Integer.parseInt(token.nextToken());
            int price = Integer.parseInt(token.nextToken());

            list.add(new Info(quality, price));
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o2.quality == o1.quality) {
                    return o1.price - o2.price;
                }
                return o2.quality - o1.quality;
            }
        });

        sb.append(list.get(0).quality).append(" ").append(list.get(0).price).append(" ").append(list.get(1).quality).append(" ").append(list.get(1).price);
        sb.append("\n");

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.price == o2.price) {
                    return o2.quality - o1.quality;
                }
                return o1.price - o2.price;
            }
        });

        sb.append(list.get(0).quality).append(" ").append(list.get(0).price).append(" ").append(list.get(1).quality).append(" ").append(list.get(1).price);
        sb.append("\n");

        System.out.print(sb);

    }
}

class Info {

    int quality;
    int price;

    public Info(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }
}

