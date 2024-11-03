package software.ulpgc.kata3.model;

import java.util.List;
import java.util.Map;

public interface TitleStatistic {
    Map<String, Integer> calculate(List<Title> titles);
}
