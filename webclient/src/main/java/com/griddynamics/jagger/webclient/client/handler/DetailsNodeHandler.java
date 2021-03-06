package com.griddynamics.jagger.webclient.client.handler;

import com.griddynamics.jagger.webclient.client.components.control.model.*;
import com.griddynamics.jagger.webclient.client.dto.PlotNameDto;
import com.griddynamics.jagger.webclient.client.dto.SessionPlotNameDto;
import com.sencha.gxt.widget.core.client.event.CheckChangeEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * User: amikryukov
 * Date: 11/27/13
 */
public class DetailsNodeHandler extends TreeAwareHandler<DetailsNode> {
    @Override
    public void onCheckChange(CheckChangeEvent<DetailsNode> event) {

        DetailsNode detailsNode = event.getItem();

        Set<PlotNameDto> testScopePlotNames = new HashSet<PlotNameDto>();
        for (TestDetailsNode test: detailsNode.getTests()) {
            for (PlotNode plotNode: test.getPlots()) {
                testScopePlotNames.add(plotNode.getPlotName());
            }
            for (MonitoringPlotNode monitoringPlotNode: test.getMonitoringPlots()) {
                for (PlotNode mPlotNode : monitoringPlotNode.getPlots()) {
                    testScopePlotNames.add(mPlotNode.getPlotName());
                }
            }
        }

        Set<SessionPlotNameDto> sessionScopePlotNames = new HashSet<SessionPlotNameDto>();
        if (detailsNode.getSessionScopePlotsNode() != null) {
            for (MonitoringSessionScopePlotNode monitoringPlotNode: detailsNode.getSessionScopePlotsNode().getPlots()) {
                for (SessionPlotNode plotNode : monitoringPlotNode.getPlots()) {
                    sessionScopePlotNames.add(plotNode.getPlotNameDto());
                }
            }
        }

        if (Tree.CheckState.CHECKED.equals(event.getChecked())) {
            sessionScopePlotFetcher.fetchPlots(sessionScopePlotNames, false);
            testPlotFetcher.fetchPlots(testScopePlotNames, true);
        } else {
            sessionScopePlotFetcher.removePlots(sessionScopePlotNames);
            testPlotFetcher.removePlots(testScopePlotNames);
        }
    }
}
