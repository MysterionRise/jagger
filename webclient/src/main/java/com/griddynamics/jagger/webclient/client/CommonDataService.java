package com.griddynamics.jagger.webclient.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.griddynamics.jagger.webclient.client.data.WebClientProperties;

@RemoteServiceRelativePath("rpc/CommonDataService")
public interface CommonDataService extends RemoteService {

    public WebClientProperties getWebClientProperties();

    public static class Async {
        private static final CommonDataServiceAsync ourInstance = (CommonDataServiceAsync) GWT.create(CommonDataService.class);

        public static CommonDataServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
