package Programmers;

public class P_86051 {
    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] visited = new boolean[10];
        for(int i : numbers){
            visited[i] = true;
        }
        for(int i =0; i< 10 ; i++){
            if(visited[i] == false){
                answer += i;
            }
        }
        return answer;
    }
}

