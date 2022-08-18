package Programmers;
import java.util.*;

public class P_42888 {
    public String[] solution(String[] record) {

        HashMap<String, UserDetail> data = new HashMap<>();
        ArrayList<String[]> logs = new ArrayList<>();
        int arrSize = 0;
        for(int i = 0 ; i< record.length; i++){
            StringTokenizer token = new StringTokenizer(record[i], " ");
            String order = token.nextToken();
            String id = token.nextToken();
            String nickname = "";
            if(!order.equals("Leave")){
                nickname = token.nextToken();
            }
            String[] log = new String[2];
            log[0] = order;
            log[1] = id; // 명령과 아이디만 기록해놓고, 추후 갱신된 데이터와 조인하여 result를 만든다.
            logs.add(log);
            switch(order){
                case "Enter":
                    data.putIfAbsent(id, new UserDetail(id));
                    data.get(id).setNick(nickname);
                    arrSize++;
                    break;
                case "Leave":
                    arrSize++;
                    break;
                case "Change":
                    data.get(id).setNick(nickname);
                    break;
            }

        }

        int index = 0;
        String[] answer = new String[arrSize];
        for(String[] log : logs){
            StringBuilder builder = new StringBuilder();
            // 닉 가져오기
            String nick = data.get(log[1]).nick;
            // order확인
            switch(log[0]){
                case "Enter" :
                    builder.append(nick).append("님이 들어왔습니다.");
                    answer[index] = builder.toString();
                    index++;
                    break;
                case "Leave" :
                    builder.append(nick).append("님이 나갔습니다.");
                    answer[index] = builder.toString();
                    index++;
                    break;
            }
        }

        return answer;
    }

    class UserDetail{
        String id;
        String nick;
        UserDetail(String id){
            this.id = id;
            nick = "";
        }
        UserDetail setNick (String nick){
            this.nick = nick;
            return this;
        }
        UserDetail getDetailFromId (String id){
            return this;
        }

        String getNickFromId (){
            return this.nick;
        }
    }
}