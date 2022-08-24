package Programmers;

public class P_12919 {
    public String solution(String[] seoul) {
        String answer = "";
        int index =0 ;
        for(String s : seoul){
            if(s.equals("Kim")){
                break;
            }
            index++;
        }
        answer = "김서방은 "+index+"에 있다";
        return answer;
    }
}
