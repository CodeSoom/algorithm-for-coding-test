import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            names.add(br.readLine());
        }

        Collections.sort(names);
        String result = "";
        int count = 0;

        String tmpName = names.get(0);
        int tmpCount = 1;
        for (int i = 1; i < names.size(); i++) {
            String name = names.get(i);
            if (tmpName.equals(name)) {
                tmpCount++;
                continue;
            }
            if (count < tmpCount) {
                result = tmpName;
                count = tmpCount;
            }
            tmpCount = 1;
            tmpName = name;
        }
        if (count < tmpCount) {
            result = tmpName;
        }

        System.out.println(result);
    }
}
