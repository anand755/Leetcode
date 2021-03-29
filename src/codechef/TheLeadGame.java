package codechef;

import java.io.*;
import java.util.Arrays;

public class TheLeadGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int roundCount = Integer.parseInt(reader.readLine());
        String[] scoreArr = new String[roundCount];
        int index = 0;
        while (roundCount-- > 0) {
            scoreArr[index++] = reader.readLine().trim();
        }
        int[] leaderScore = getLeaderAndScore(scoreArr);
        writer.write(leaderScore[0] + " " + leaderScore[1]);
        writer.flush();
    }

    private static int[] getLeaderAndScore(String[] allScoreArr) {
        int[] leader_score = new int[2];
        int leader = 0;
        int currLead = 0;
        int maxLead = Integer.MIN_VALUE;
        for (String scores : allScoreArr) {
            int[] scoresArr = Arrays.stream(scores.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int score1 = scoresArr[0];
            int score2 = scoresArr[1];
            currLead = Math.abs(score1 - score2);
            if (currLead > maxLead) {
                leader = score1 > score2 ? 1 : 2;
                maxLead = currLead;
            }
        }
        leader_score[0] = leader;
        leader_score[1] = maxLead;
        return leader_score;
    }
}
