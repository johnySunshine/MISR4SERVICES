package com.msir.utils;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public abstract class HttpUtils {

    public static URI converseURI(String schemeName, String hostName, String pathName, List<Map<String, String>> params) {
        URI apiURL = null;
        URIBuilder urlBuilder = new URIBuilder();
        try {
            urlBuilder.setHost(hostName);
            urlBuilder.setPath(pathName);
            urlBuilder.setParameters();
            if (null != params || params.isEmpty()) {
                for (Map<String, String> map : params) {
                    if (null != map) {
                        urlBuilder.setParameter(map.get(""),map.get(""));
                    }
                }
            }
            apiURL = urlBuilder.build();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return apiURL;
    }
}
