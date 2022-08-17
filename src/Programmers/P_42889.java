package Programmers;
import java.util.*;
public class P_42889 {
    public int[] solution(int N, int[] stages) {
        ArrayList<STAGE_FAIL_DATA> list  = new ArrayList<>();
        for(int i = 0; i<= N+1 ; i++) {
            list.add(new STAGE_FAIL_DATA(i));
        } // 스테이지 정보 초기화 + 0stage dummy 추가, N+1스테이지 고려하여 +1 더미 추가

        //stages 정보 불러오면서, list에 정보 add
        for(int i = 0; i< stages.length ; i++){
            int nowStage = stages[i];
            for(int j = 1; j<= nowStage ; j++){
                list.get(j).increTryNum();
            }
            list.get(nowStage).increFailedNum();
        }

        for(STAGE_FAIL_DATA data : list){
            data.cal();
        }
        // sorting 전 더미 삭제
        list.remove(0);
        list.remove(list.size()-1);
        // sorting
        Collections.sort(list, new Comparator<STAGE_FAIL_DATA>(){
            public int compare(STAGE_FAIL_DATA o1, STAGE_FAIL_DATA o2){
                if(Double.compare(o1.percentage, o2.percentage)>0){
                    return -1;
                }else if(Double.compare(o1.percentage, o2.percentage)==0){
                    return o1.N - o2.N;
                }else{
                    return 1;
                }
            }
        });
        int[] answer = new int[N];
        int index = 0;
        for(STAGE_FAIL_DATA data : list){
            answer[index] = data.N;
            index++;
        }


        return answer;
    }

    private static class STAGE_FAIL_DATA{
        int N; // stage 단계
        int tryNum; // 스테이지 도달한 플레이어 수
        int failedNum; // 아직 클리어하지 못한 사람의 수
        double percentage; // 실패율
        STAGE_FAIL_DATA(int N){
            this.N = N;
            tryNum = 0;
            failedNum = 0;
            percentage = 0; // 디폴트 0값
        }

        private STAGE_FAIL_DATA cal(){
            if(tryNum != 0){
                percentage = (failedNum / (double)tryNum);
            }
            return this;
        }

        private STAGE_FAIL_DATA increTryNum(){
            tryNum++;
            return this;
        }
        private STAGE_FAIL_DATA increFailedNum(){
            failedNum++;
            return this;
        }
    }
}
