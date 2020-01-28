package com.logicbig.example;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class MyContextResolver implements
        ContextResolver<MyContext> {
    private MyContext context = new MyContextImpl();

    @Override
    public MyContext getContext(Class<?> type) {
        if (type == String.class) {
            return context;
        }
        return null;
    }

    private static class MyContextImpl implements MyContext<String> {
        @Override
        public String get(String key) {
            return "a context value for key=" + key;
        }
    }
}