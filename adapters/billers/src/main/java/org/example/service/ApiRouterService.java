package org.example.service;

public interface ApiRouterService<REQUEST, RESPONSE> extends ApiConsumeService<REQUEST, RESPONSE> {
    Object routeService(String serviceName, String method, Object ...parameters);
}
