package kama;

import java.util.*;
import java.util.stream.Collectors;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            map.put(a, map.getOrDefault(a, new ArrayList<>()));
            map.get(a).add(b);
        }
//        System.out.println(map);
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(1, map, new int[n + 1], new ArrayList<>(), allPaths, n);
        for (List<Integer> path : allPaths) {
            List<String> collect = path.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ", collect));
        }

    }


    private static void dfs(int node, Map<Integer, List<Integer>> map, int[] visited, List<Integer> curPath, List<List<Integer>> allPaths, int n) {
        if (visited[node] == 1) return;
        visited[node] = 1;
        curPath.add(node);
        System.out.println(node);

        if (node == n) {
//            System.out.println("111");
            allPaths.add(new ArrayList<>(curPath));
        }

        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                dfs(next, map, visited, curPath, allPaths, n);
            }
        }

        visited[node] = 0;
        if (curPath.size() > 0) {
            curPath.remove(curPath.size() - 1);
        }
    }



}
