package org.nrnb.gsoc.enrichment.tasks;

import org.cytoscape.model.CyTable;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskMonitor;
import org.jfree.chart.ui.UIUtils;

public class EnrichmentChartVisualisationFactory extends AbstractTask implements ObservableTask {

    private final CyTable enrichmentTable;

    public EnrichmentChartVisualisationFactory(CyTable enrichmentTable) {
        this.enrichmentTable = enrichmentTable;
    }

    @Override
    public void run(TaskMonitor taskMonitor) {
        System.out.println("Ring chart creation started");
        EnrichmentChartVisualisationTask chartVisualisationTask =
                new EnrichmentChartVisualisationTask(enrichmentTable);
        chartVisualisationTask.pack();
        UIUtils.centerFrameOnScreen(chartVisualisationTask);
        chartVisualisationTask.setVisible(true);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getResults(Class type) {
        Long res = enrichmentTable.getSUID();
        return res;
    }
}
