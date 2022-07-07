package Menu;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RankingProvider {

    String urlRanking = "./Rankings/Ranking.txt";
    ArrayList<String> ranking = new ArrayList<>();
BufferedReader bufferedReader=null;
    public RankingProvider() throws IOException {
        loadRanking();
    }

    private void loadRanking() {
ArrayList<String> arrayList=new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(urlRanking));
            String sources = bufferedReader.readLine();
        while(sources!=null){
                arrayList.add(sources);
                sources = bufferedReader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ranking=arrayList;
    }
    public ArrayList<String> getRanking(){
        return ranking;
    }
}
