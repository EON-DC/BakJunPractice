package Programmers;

import java.util.ArrayList;

public class P_42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Project> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            list.add(new Project(progresses[i], speeds[i]));
        }


        ArrayList<Integer> ansList = new ArrayList<>();

        while (!isFunctionAllDone(list)) {
            doList(list);
            int hasLuanchedCount = launchEnableProject(list);
            if (hasLuanchedCount != 0) {
                ansList.add(hasLuanchedCount);
            }
        }

        answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    static class Project {
        int progress;
        int speed;
        boolean isComplete;
        boolean isLuanched;

        Project(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
            isComplete = false;
            isLuanched = false;
        }

        Project plusDay() {
            if (!isComplete) {
                progress += speed;
                if (progress >= 100) {
                    isComplete = true;
                }
            }

            return this;
        }

        Project launch() {
            if (isComplete && !isLuanched) {
                isLuanched = true;
            }
            return this;
        }
    }

    boolean isFunctionAllDone(ArrayList<Project> list) {
        for (Project p : list) {
            if (!p.isLuanched)
                return false;
        }
        return true;
    }

    void doList(ArrayList<Project> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).plusDay();
        }
    }

    int launchEnableProject(ArrayList<Project> list) {
        int hasLuanchedCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Project testUnit = list.get(i);
            if (!testUnit.isComplete) {
                break;
            } else if (testUnit.isComplete && testUnit.isLuanched) {
                continue;
            } else {
                testUnit.launch();
                hasLuanchedCount++;
            }
        }
        return hasLuanchedCount;
    }
}

