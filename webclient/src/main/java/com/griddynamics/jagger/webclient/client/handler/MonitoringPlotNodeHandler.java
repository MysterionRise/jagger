package com.griddynamics.jagger.webclient.client.handler;

import com.griddynamics.jagger.webclient.client.components.control.model.MonitoringPlotNode;
import com.griddynamics.jagger.webclient.client.components.control.model.PlotNode;
import com.griddynamics.jagger.webclient.client.dto.PlotNameDto;
import com.sencha.gxt.widget.core.client.event.CheckChangeEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: amikryukov
 * Date: 12/11/13
 */
public class MonitoringPlotNodeHandler extends TreeAwareHandler<MonitoringPlotNode> {
    @Override
    public void onCheckChange(CheckChangeEvent<MonitoringPlotNode> event) {

        Set<PlotNameDto> dtos = new LinkedHashSet<PlotNameDto>();

        for (PlotNode plot: event.getItem().getPlots()) {
            dtos.add(plot.getPlotName());
        }

        if (Tree.CheckState.CHECKED.equals(event.getChecked())) {
            testPlotFetcher.fetchPlots(dtos, true);
        } else {
            testPlotFetcher.removePlots(dtos);
        }
    }
}
