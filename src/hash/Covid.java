package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Covid {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CBHT<String, String> pozitivni = new CBHT<String, String>(2 * N);
        CBHT<String, String> negativni = new CBHT<String, String>(2 * N);
        for (int i = 0; i < N; i++) {
            String p[] = bf.readLine().split(" ");
            String opstina = p[0];
            String prezime = p[1];
            String rezultat = p[2];
            if (rezultat.equals("pozitiven"))
                pozitivni.insert(opstina, prezime);
            else
                negativni.insert(opstina, prezime);
        }
        String opstina = bf.readLine();
        int poz = 0;
        SLLNode<MapEntry<String, String>> pom = pozitivni.search(opstina);
        while (pom != null) {
            poz++;
            pom = pom.succ;
        }
        int neg = 0;
        pom = negativni.search(opstina);
        while (pom != null) {
            neg++;
            pom = pom.succ;
        }
        float riskFaktor = (float) poz / (neg + poz);
        System.out.println(String.format("%.2f", riskFaktor));
    }
}
