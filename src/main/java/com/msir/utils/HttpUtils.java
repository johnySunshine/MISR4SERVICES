package com.msir.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public abstract class HttpUtils {
    private static String schemeName;
    private static String hostName;
    private static String pathName;
    private static int port;
    static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

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

    public static String httpsManager4get(URI apiUri) {
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent(USER_AGENT);
        final CloseableHttpClient httpclient = builder.build();
        CloseableHttpResponse response = null;
        HttpEntity entity;
        String responseStr = "";
        try {
            HttpGet httpget = new HttpGet(apiUri);
            response = httpclient.execute(httpget);
            entity = response.getEntity();
            responseStr = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }
}
