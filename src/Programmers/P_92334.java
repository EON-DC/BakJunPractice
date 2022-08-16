package Programmers;
import java.util.*;

class P_92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        ArrayList<UserDetail> userList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            String userName = id_list[i];
            UserDetail detail = new UserDetail(i, userName);
            userList.add(detail);
        }

        for (int i = 0; i < report.length; i++) {
            StringTokenizer token = new StringTokenizer(report[i]);
            String caller = token.nextToken();
            String bUser = token.nextToken();
            UserDetail userDetail = userList.stream().filter(u -> u.userName.equals(caller)).findAny().get();
            userDetail.userReport.add(bUser);
            UserDetail badUserDetail = userList.stream().filter(u -> u.userName.equals(bUser)).findAny().get();
            badUserDetail.reportedByName.add(caller);
        }
        for (UserDetail user : userList) {
            Set<String> reportedByName = user.reportedByName;
            if (reportedByName.size() >= k) {
                // 정지 메일 발송
                user.gottenMailCount++;
                Iterator<String> iterator = reportedByName.iterator();
                while (iterator.hasNext()) {
                    String caller = iterator.next();
                    userList.stream().filter(u -> u.userName.equals(caller)).findAny().get().gottenMailCount++;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (UserDetail user : userList) {
            result.add(user.gottenMailCount);
        }
        int size = result.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class UserDetail {
        int userIndex;
        String userName;
        Set<String> userReport = new HashSet<>();
        Set<String> reportedByName = new HashSet<>();

        int gottenMailCount = 0;

        public UserDetail(int userIndex, String userName) {
            this.userIndex = userIndex;
            this.userName = userName;
        }
    }


}