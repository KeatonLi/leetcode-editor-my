package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class 统计用户被提及情况 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            int[] users = new int[numberOfUsers];
            boolean[] userOnline = new boolean[numberOfUsers];
            Arrays.fill(userOnline, true);
            int[] lastOnline = new int[numberOfUsers];
            events.sort((o1, o2) -> Integer.parseInt(o1.get(1)) != Integer.parseInt(o2.get(1)) ? Integer.parseInt(o1.get(1)) - Integer.parseInt(o2.get(1)) : o2.get(0).compareTo(o1.get(0)));
//            System.out.println(events);
            for (List<String> event : events) {
                if (event.get(0).equals("MESSAGE")) {
                    Integer time = Integer.parseInt(event.get(1));
                    String userId = event.get(2);
                    if (userId.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (userOnline[i]) {
                                users[i]++;
                            } else {
                                if (lastOnline[i] <= time) {
                                    userOnline[i] = true;
                                    users[i]++;
                                }
                            }
                        }
                    } else if (userId.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            users[i]++;
                        }
                    } else {
                        String[] userIds = userId.split(" ");
                        for (String id : userIds) {
                            int index = Integer.parseInt(id.substring(2));
                            users[index]++;
                        }
                    }
                } else if (event.get(0).equals("OFFLINE")) {
                    Integer time = Integer.parseInt(event.get(1));
                    Integer userId = Integer.parseInt(event.get(2));
                    userOnline[userId] = false;
                    lastOnline[userId] = time + 60;
                }
            }

            return users;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}