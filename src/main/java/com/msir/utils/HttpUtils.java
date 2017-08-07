package com.msir.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public abstract class HttpUtils {
    private static String schemeName;
    private static String hostName;
    private static String pathName;
    private static int port;

    public static void setSchemeName(String schemeName) {
        HttpUtils.schemeName = schemeName;
    }

    public static void setHostName(String hostName) {
        HttpUtils.hostName = hostName;
    }

    public static void setPathName(String pathName) {
        HttpUtils.pathName = pathName;
    }

    public static void setPort(int port) {
        HttpUtils.port = port;
    }

    public static URI converseURI(List<NameValuePair> params) {
        URI apiURL = null;
        URIBuilder urlBuilder = new URIBuilder();
        try {
            urlBuilder.setScheme(HttpUtils.schemeName);
            urlBuilder.setHost(HttpUtils.hostName);
            urlBuilder.setPath(HttpUtils.pathName);
            if (HttpUtils.port != 0) {
                urlBuilder.setPort(HttpUtils.port);
            }
            urlBuilder.setParameters(params);
            apiURL = urlBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return apiURL;
    }

    public static URI converseURI() {
        URI apiURL = null;
        URIBuilder urlBuilder = new URIBuilder();
        try {
            urlBuilder.setScheme(HttpUtils.schemeName);
            urlBuilder.setHost(HttpUtils.hostName);
            urlBuilder.setPath(HttpUtils.pathName);
            if (HttpUtils.port != 0) {
                urlBuilder.setPort(HttpUtils.port);
            }
            apiURL = urlBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return apiURL;
    }

}
