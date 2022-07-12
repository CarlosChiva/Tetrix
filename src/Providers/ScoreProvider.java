package Providers;

import java.io.*;

import java.util.*;
import java.util.Comparator;

public class ScoreProvider {

    String urlRanking = "./Rankings/Ranking.txt";

    ArrayList<String> ranking = new ArrayList<>();

    public ScoreProvider() {
        loadRanking();
    }

    private void loadRanking() {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(urlRanking))) {
            String sources = bufferedReader.readLine();
            while (sources != null) {
                arrayList.add(sources);
                sources = bufferedReader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ranking = arrayList;
    }

    public ArrayList<String> getRanking() {
        return ranking;
    }


    public void saveScore(int newScore) {
        ranking.add(String.valueOf(newScore));
        HashSet<Integer> aux = new HashSet<>();

        for (String asf : ranking) {
            aux.add(Integer.valueOf(asf));
        }
        ArrayList<Integer> aux2=new ArrayList<>(aux);
        Collections.sort(aux2,Comparator.reverseOrder());

        try (PrintWriter bufferedWriter = new PrintWriter(new FileOutputStream(urlRanking))) {
            for (Integer score : aux2) {
                bufferedWriter.println(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

