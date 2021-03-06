package com.griddynamics.jagger.webclient.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.griddynamics.jagger.webclient.client.dto.PlotNameDto;
import com.griddynamics.jagger.webclient.client.dto.PlotSeriesDto;
import com.griddynamics.jagger.webclient.client.dto.SessionPlotNameDto;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author "Artem Kirillov" (akirillov@griddynamics.com)
 * @since 5/30/12
 */
public interface PlotProviderServiceAsync {

    void getSessionScopePlotData(String sessionId, Collection<SessionPlotNameDto> plotType, AsyncCallback<Map<SessionPlotNameDto, List<PlotSeriesDto>>> async);

    void getPlotDatas(Set<PlotNameDto> plots, AsyncCallback<Map<PlotNameDto,List<PlotSeriesDto>>> async);

    void getPlotData(Set<Long> taskId, PlotNameDto plotType, AsyncCallback<List<PlotSeriesDto>> async);

    void getPlotData(long taskId, PlotNameDto plotType, AsyncCallback<List<PlotSeriesDto>> async);
}
