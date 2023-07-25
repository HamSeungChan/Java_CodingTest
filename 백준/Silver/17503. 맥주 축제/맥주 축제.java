import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = -1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new PriorityQueue<>();

        List<Beer> beerList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int like = sc.nextInt();
            int die = sc.nextInt();
            beerList.add(new Beer(like, die));
        }
        Collections.sort(beerList);
        int sum = 0;
        for(Beer beer : beerList){
            q.add(beer.like);
            sum += beer.like;

            if(q.size()>n){
                sum -= q.poll();
            }

            if(sum >= m && q.size() == n){
                answer = beer.die;
                break;
            }
        }
        System.out.println(answer);
    }
}

class Beer implements Comparable<Beer> {
    int like;
    int die;

    public Beer(int like, int die) {
        this.like = like;
        this.die = die;
    }

    @Override
    public int compareTo(Beer o) {
        if (this.die == o.die) {
            return o.like - this.like;
        }
        return this.die - o.die;
    }
}