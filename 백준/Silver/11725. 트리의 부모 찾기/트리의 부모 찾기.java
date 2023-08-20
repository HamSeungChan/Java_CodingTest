import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static List<List<Integer>> list;
    static int [] array;
    static boolean [] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        array = new int[n];
        check = new boolean[n];


        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;

            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(0);

        for(int i = 1; i< array.length; i++){
            System.out.println(array[i] + 1);
        }
    }

    public static void DFS(int n){
        check[n] = true;

        for(int i : list.get(n)){
            if(!check[i]){
                array[i] = n;
                DFS(i);
            }
        }

    }


}