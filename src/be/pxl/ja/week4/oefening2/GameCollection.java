package be.pxl.ja.week4.oefening2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameCollection {
    private ArrayList<VideoGame> videoGames;

    public GameCollection() {
        videoGames = new ArrayList<>();
    }

    public void addGame(VideoGame videoGame) {
        videoGames.add(videoGame);
    }

    public ArrayList<VideoGame> selectGames(Predicate<VideoGame> filter) {
        ArrayList<VideoGame> result = new ArrayList<>();

        for (VideoGame videoGame:videoGames) {
            if (filter.test(videoGame)) {
                result.add(videoGame);
            }
        }

        return result;
    }
}
