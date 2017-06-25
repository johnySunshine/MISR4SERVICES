/**
 * Created by Fantasy on 2017/6/25.
 */
var local = window.location;
var contextPath = local.pathname.split("/")[1];
var basePath = local.protocol+"//"+local.host+"/"+contextPath;