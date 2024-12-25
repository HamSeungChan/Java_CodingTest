import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Info[] array = new Info[8];


        for (int i = 0; i < 8; i++) {
            int value = Integer.parseInt(br.readLine());
            array[i] = new Info(i + 1, value);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(array, new Comparator<>() {

            @Override
            public int compare(Info o1, Info o2) {
                return o2.value - o1.value;
            }
        });

        int totalSum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            totalSum += array[i].value;
            list.add(array[i].index);
        }

        sb.append(totalSum).append("\n");

        Collections.sort(list);
        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}

class Info {

    int index;
    int value;

    public Info(int index, int value) {
        this.index = index;
        this.value = value;
    }
}