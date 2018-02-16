package solved;

import java.util.*;

class Job {
    char jobType;
    Integer jobFreq;
}

public class MInimizeJobRunTimeToSImilarJobTogether {

    void printSeq(List<Job> jobs) {
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return (o1.jobFreq > o2.jobFreq) ? -1 : (o1.jobFreq == o2.jobFreq) ? 0 : 1;
            }
        });
        for (char a : getData(jobs.listIterator())) {
            System.out.print(a);
        }

    }

    private Character[] getData(ListIterator<Job> jobs) {
        List<Character> solList = new ArrayList<Character>();
        Job j;
        while ((j = jobs.next()) != null) {
            char arr[] = new char[2 * j.jobFreq - 1];
            arr[0] = j.jobType;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = '_';
                arr[++i] = j.jobType;
            }
            // A_A_A_A_A_A

            Character[] oldArr = solList.toArray(new Character[solList.size()]);
            int pointer = oldArr.length - 1;
            solList = new ArrayList<Character>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != '_') solList.add(arr[i]);
                else {
                    if (pointer == -1) solList.add(arr[i]);
                    else {
                        while (oldArr[pointer] != '_') {
                            pointer--;
                        }
                        solList.add(oldArr[pointer]);
                        pointer--;
                    }
                }
            }
            if (pointer != -1) {
                solList.add(oldArr[pointer]);
                pointer--;
            }


        }
        return solList.toArray(new Character[solList.size()]);

    }

}
