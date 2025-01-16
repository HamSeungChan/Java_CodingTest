import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Queue<Student> pq = new PriorityQueue<>();


        int classCount = 0;               // 대표 선수가 선택된 반의 수
        int[] classPickCount = new int[n];     // 반에서 몇 명 선택되었는지 저장하는 배열
        Student[] students = new Student[n * m];


        int index = 0;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                students[index++] = new Student(Integer.parseInt(token.nextToken()), i);
            }
        }

        Arrays.sort(students);

        int lt = 0;
        int answer = Integer.MAX_VALUE;
        for (int rt = 0; rt < n * m; rt++) {
            Student now = students[rt];

            // 반에서 처음 뽑는 학생이라면
            if (classPickCount[now.classNumber] == 0) {
                {
                    classCount++;
                }
            }

            classPickCount[now.classNumber]++;      // 뽑은 학생의 반 Count 증가

            // 반 학생 전부를 뽑은 경우
            while (classCount == n) {
                answer = Math.min(answer, now.score - students[lt].score);
                classPickCount[students[lt].classNumber]--;
                if (classPickCount[students[lt].classNumber] == 0) {
                    classCount--;
                }
                lt++;
            }

        }
        System.out.println(answer);
    }
}

class Student implements Comparable<Student> {

    int score;
    int classNumber;

    public Student(int score, int classNumber) {
        this.score = score;
        this.classNumber = classNumber;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}