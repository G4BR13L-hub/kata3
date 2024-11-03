package software.ulpgc.kata3.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.model.Barchart;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(
                "Movie Statistics",
                barchart.getTitle(),
                "Number of Films",
                datasetOf(barchart)
        );
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String category : barchart.categories()) {
            dataset.addValue(barchart.get(category), "", category);
        }
        return dataset;
    }
}
