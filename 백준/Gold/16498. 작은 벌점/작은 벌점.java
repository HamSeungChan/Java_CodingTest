import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        int[] arrayA = new int[a];
        int[] arrayB = new int[b];
        int[] arrayC = new int[c];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a; i++) {
            arrayA[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < b; i++) {
            arrayB[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            arrayC[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Arrays.sort(arrayC);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < a; i++) {
            int tmp = arrayA[i];
            // arrayB 에거 가장 가까운 값 찾기
            int lt = 0;
            int rt = b - 1;
            int bValue = Integer.MAX_VALUE;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (tmp == arrayB[mid]) {
                    bValue = arrayB[mid];
                    break;
                } else if (tmp < arrayB[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
                if (Math.abs(tmp - arrayB[mid]) < Math.abs(tmp - bValue)) {
                    bValue = arrayB[mid];
                }
            }

            // arrayC 에서 가장 가까운 값 찾기 (a 의 값 기준)
            lt = 0;
            rt = c - 1;
            int cValue1 = Integer.MAX_VALUE;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (cValue1 == arrayC[mid]) {
                    cValue1 = arrayC[mid];
                    break;
                } else if (tmp < arrayC[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
                if (Math.abs(tmp - arrayC[mid]) < Math.abs(tmp - cValue1)) {
                    cValue1 = arrayC[mid];
                }
            }

            // arrayC에서 가장 가까운 값 찾기(b 의 값 기준)
            lt = 0;
            rt = c - 1;
            int cValue2 = Integer.MAX_VALUE;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arrayC[mid] == bValue) {
                    cValue2 = arrayC[mid];
                    break;
                } else if (bValue < arrayC[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
                if (Math.abs(bValue - arrayC[mid]) < Math.abs(bValue - cValue2)) {
                    cValue2 = arrayC[mid];
                }
            }

            answer = Math.min(answer, Math.max(bValue, Math.max(cValue1, tmp)) - Math.min(bValue, Math.min(cValue1, tmp)));
            answer = Math.min(answer, Math.max(bValue, Math.max(cValue2, tmp)) - Math.min(bValue, Math.min(cValue2, tmp)));
        }
        System.out.println(answer);
    }
}