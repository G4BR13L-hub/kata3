package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Barchart;
import software.ulpgc.kata3.model.DecadeMovieTitleStatistic;
import software.ulpgc.kata3.model.Title;
import software.ulpgc.kata3.view.BarchartDisplay;

import java.util.List;
import java.util.Map;

public class BarchartCommand implements Command{
    private BarchartDisplay barchartDisplay;
    private final List<Title> titles;

    public BarchartCommand(List<Title> titles, BarchartDisplay barchartDisplay) {
        this.titles = titles;
        this.barchartDisplay = barchartDisplay;
    }

    @Override
    public void execute() {
        barchartDisplay.display(getBarchart());
    }

    private Barchart getBarchart() {
        Barchart barchart = new Barchart("Decades");
        Map<String, Integer> stats = new DecadeMovieTitleStatistic().calculate(titles);
        for (String stat : stats.keySet()) {
            barchart.put(stat, stats.get(stat));
        }
        return barchart;
    }
}
