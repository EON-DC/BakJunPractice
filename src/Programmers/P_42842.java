package Programmers;

public class P_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int plus = brown/2+2;
        int multi = yellow + brown;
        int width = 1;
        int height = plus - width;
        while(width * height != multi){
            width++;
            height = plus - width;
        }
        int temp = 0;
        if(width < height){
            temp = height;
            height = width;
            width = temp;
        }
        answer[0] = width;
        answer[1] = height;
        return answer;
    }


    /*
     * 둘레 길이 2w + 2h , 갈색 넓이는 2w+2h-4
     * (w-2) * (h-2) 내부 넓이
     * w*h 와 w+h 는 구할 수 있음. 일차 방정식 문제
     * w >= h 일 때, w, h는?
     */
}