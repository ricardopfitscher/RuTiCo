import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int n = line.length;

        int l = 0;
        ArrayList<Node> groups = new ArrayList<>();
        Node node = new Node(line[0], 1);
        groups.add(node);
        for (int i = 1; i < n; i++) {
            if (line[i] == groups.get(l).letter) {
                groups.get(l).count++;
            } else {
                node = new Node(line[i], 1);
                groups.add(node);
                l++;
            }
        }

        int moves = 0;
        ArrayList<Node> temp = new ArrayList<>();
        while (groups.size() > 1) {
            moves++;

            l = groups.size();
            groups.get(0).count--;
            groups.get(l - 1).count--;
            for (int i = 1; i < l - 1; i++) {
                groups.get(i).count -= 2;
            }

            int p;
            for (p = 0; p < l; p++) {
                if (groups.get(p).count > 0) {
                    temp.add(groups.get(p));
                    break;
                }
            }
            int lTemp = temp.size();
            for (p++; p < l; p++) {
                if (groups.get(p).count <= 0) {
                    continue;
                }
                if (groups.get(p).letter == temp.get(lTemp - 1).letter) {
                    temp.get(lTemp - 1).count += groups.get(p).count;
                } else {
                    temp.add(groups.get(p));
                    lTemp++;
                }
            }

            groups.clear();
            groups.addAll(temp);
            temp.clear();
        }

        System.out.println(moves);
    }

    private static class Node {
        char letter;
        int count;

        Node(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}
