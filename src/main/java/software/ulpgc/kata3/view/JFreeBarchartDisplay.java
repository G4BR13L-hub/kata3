package software.ulpgc.kata3.view;

import org.jfree.chart.ChartPanel;
import software.ulpgc.kata3.model.Barchart;

import javax.swing.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    @Override
    public void display(Barchart barchart) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart)));
        revalidate();
    }
}
