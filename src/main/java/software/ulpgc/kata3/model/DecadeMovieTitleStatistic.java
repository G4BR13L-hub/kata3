package software.ulpgc.kata3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecadeMovieTitleStatistic implements TitleStatistic{

    @Override
    public Map<String, Integer> calculate(List<Title> titles) {
        Map<String, Integer> statsByDecade = new HashMap<>();
        for (Title title : titles) {
            toInterval(title, statsByDecade);
        }
        return statsByDecade;
    }

    private static void toInterval(Title title, Map<String, Integer> statsByDecade) {
        String decade = (title.getYear() / 10 * 10) + "s";  // Ejemplo: convierte 1995 en "1990s"
        if (title.getYear() > 0) {
            statsByDecade.put(decade, statsByDecade.getOrDefault(decade, 0) + 1);
        }
    }
}
