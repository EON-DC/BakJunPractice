package Programmers;

public class P_12977 {
    static int count;

    public int solution(int[] nums) {
        int answer = -1;

        // numLength 중 3개 조합
        count = 0;
        int N = nums.length;
        boolean[] visited = new boolean[N];

        combination(nums, visited, 0, N, 3);

        answer = count;


        return answer;
    }

    public static void combination (int[] nums, boolean[] visited, int start, int N, int r){
        if(r==0){
            int sum = 0;
            for(int i =0; i< N; i++){
                if(visited[i]){
                    sum += nums[i];
                }
            }
            if(verifyPrimary(sum)){
                count++;
            }
            return;
        }
        for(int i = start ; i<N ; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(nums, visited, i+1, N, r-1);
                visited[i] = false;
            }
        }
    }

    public static boolean verifyPrimary(int n){
        if(n == 1){
            return false;
        }else if(n == 2){
            return true;
        }else{
            for(int i = 2; i < (int)Math.sqrt(n)+1 ; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }


    }
}