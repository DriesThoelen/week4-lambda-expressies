package be.pxl.ja.week4.oefening2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameBrowser {

    private GameCollection gameCollection;

    public GameBrowser(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public ArrayList<VideoGame> showGamesForSearch(String search) {
        return gameCollection.selectGames(new Predicate<VideoGame>() {
            @Override
            public boolean test(VideoGame videoGame) {
                if (videoGame.getName().toUpperCase().contains(search.toUpperCase())) {
                    return true;
                }
                return false;
            }
        });
    }

    public ArrayList<VideoGame> showFreeGames() {
        Predicate<VideoGame> freeGamesFilter = v -> (v.getPrice() == 0.0);
        return gameCollection.selectGames(freeGamesFilter);
    }

    public ArrayList<VideoGame> showGamesInGenre(String genre) {
        Predicate<VideoGame> genreFilter = v -> (v.getGenres().contains(genre));
        return gameCollection.selectGames(genreFilter);
    }
}