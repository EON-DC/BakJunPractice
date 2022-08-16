package Programmers;

import java.util.HashMap;

public class P_67256 {
    public String solution(int[] numbers, String hand) {
        String answer = new HAND(numbers, hand).getResult();
        return answer;
    }

    private static class HAND {
        String primaryHand;
        int[] numbers;
        int LHandPosition;
        int RHandPosition;
        HashMap<Integer, String> mapping;
        HashMap<Integer, Integer[]> keypad;

        HAND(int[] numbers, String hand) {
            this.primaryHand = hand;
            this.numbers = numbers;
            mapping = new HashMap<>();
            mapping.put(1, "L");
            mapping.put(4, "L");
            mapping.put(7, "L");
            mapping.put(3, "R");
            mapping.put(6, "R");
            mapping.put(9, "R");
            keypad = new HashMap<>();
            keypad.put(1, new Integer[]{0, 3});
            keypad.put(2, new Integer[]{1, 3});
            keypad.put(3, new Integer[]{2, 3});
            keypad.put(4, new Integer[]{0, 2});
            keypad.put(5, new Integer[]{1, 2});
            keypad.put(6, new Integer[]{2, 2});
            keypad.put(7, new Integer[]{0, 1});
            keypad.put(8, new Integer[]{1, 1});
            keypad.put(9, new Integer[]{2, 1});
            keypad.put(11, new Integer[]{0, 0}); // * : 11
            keypad.put(0, new Integer[]{1, 0});
            keypad.put(12, new Integer[]{2, 0}); // # : 12
            LHandPosition = 11;
            RHandPosition = 12;

        }

        private String getResult() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (mapping.containsKey(numbers[i])) { // 미리 맵핑된 케이스는 바로 builder에 넣을 수 있도록 함
                    String temp = mapping.get(numbers[i]);
                    result.append(temp);
                    if (temp.equals("L")) { // 엄지손의 마지막 위치 보정
                        LHandPosition = numbers[i];
                    } else {
                        RHandPosition = numbers[i];
                    }
                    continue;
                } else { // 맵핑이 안된 경우엔, target되는 keypad의 왼손, 오른손 거리를 도출하고, 위치 조정 다시
                    int x = keypad.get(numbers[i])[0];
                    int y = keypad.get(numbers[i])[1];

                    int Lx = keypad.get(LHandPosition)[0];
                    int Ly = keypad.get(LHandPosition)[1];

                    int Rx = keypad.get(RHandPosition)[0];
                    int Ry = keypad.get(RHandPosition)[1];

                    int LDistance = Math.abs(Lx - x) + Math.abs(Ly - y);
                    int RDistance = Math.abs(Rx - x) + Math.abs(Ry - y);

                    if (LDistance == RDistance) {
                        if (primaryHand.equals("right")) {
                            result.append("R");
                            RHandPosition = numbers[i];
                        } else {
                            result.append("L");
                            LHandPosition = numbers[i];
                        }
                    } else if (LDistance < RDistance) {
                        result.append("L");
                        LHandPosition = numbers[i];
                    } else {
                        result.append("R");
                        RHandPosition = numbers[i];
                    }
                }// 맵핑 된경우 안된 경우 구분

            } // for문 종료
            return result.toString();
        }

    }
}