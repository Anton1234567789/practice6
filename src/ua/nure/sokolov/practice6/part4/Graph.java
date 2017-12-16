package ua.nure.sokolov.practice6.part4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        ArrayList<Integer> gr[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }

        int s = 0;
        for (int i = 0; i < m; i++) {
            int u, v;
            u = scanner.nextInt();
            v = scanner.nextInt();
            gr[u - 1].add(v - 1);
            gr[v - 1].add(u - 1);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(s);
        boolean used[] = new boolean[n];
        used[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.peek();
            queue.pop();
            for (int i = 0; i < gr[v].size(); ++i) {
                int to = gr[v].get(i);
                if (!used[to]) {
                    used[to] = true;
                    queue.push(to);
                }
            }
        }
        String answer = "YES";
        for (int i = 0; i < used.length; i++) {
            if (used[i] == false) {
                answer = "NO";
            }
        }
        System.out.println(answer);
    }
}

