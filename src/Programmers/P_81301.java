package Programmers;

public class P_81301 {
    public int solution(String s) {
        int answer = new KAKAOGAME(s)
                .replaceWord()
                .getResult();
        return answer;
    }

    private static class KAKAOGAME{
        private String s;
        KAKAOGAME(String s){
            this.s = s;
        }

        private KAKAOGAME replaceWord(){
            s = s.replaceAll("one", "1")
                    .replaceAll("two","2")
                    .replaceAll("three","3")
                    .replaceAll("four","4")
                    .replaceAll("five","5")
                    .replaceAll("six","6")
                    .replaceAll("seven","7")
                    .replaceAll("eight","8")
                    .replaceAll("nine","9")
                    .replaceAll("zero","0");
            return this;
        }

        private int getResult(){
            return Integer.parseInt(s);
        }
    }
}