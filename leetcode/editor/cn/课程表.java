package leetcode.editor.cn;

import java.util.*;

class 课程表{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 出度
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 入度
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0 ; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            map2.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
            map2.get(prerequisite[0]).add(prerequisite[1]);
        }
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree[i] = map2.get(i).size();
            if (inDegree[i] == 0) {
                queue.offer(i);
                inDegree[i] = -1;
            }
        }
//        System.out.println(Arrays.toString(inDegree));
//        System.out.println(map);
//        System.out.println(map2);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : map.get(cur)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                        inDegree[next] = -1;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(inDegree));
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != -1) {
                return false;
            }
        }
        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}