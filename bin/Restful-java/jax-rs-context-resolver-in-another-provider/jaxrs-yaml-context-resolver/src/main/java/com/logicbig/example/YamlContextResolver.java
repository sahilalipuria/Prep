package com.logicbig.example;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class YamlContextResolver implements
        ContextResolver<YamlContext> {
    private YamlContext defaultContext = new SnakeYamlContext();

    @Override
    public YamlContext getContext(Class<?> type) {
        //we can restrict the return value based on type
        return defaultContext;
    }
}