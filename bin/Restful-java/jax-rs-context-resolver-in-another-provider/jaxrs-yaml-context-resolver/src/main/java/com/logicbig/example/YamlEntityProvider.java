package com.logicbig.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes({"application/yaml", MediaType.TEXT_PLAIN})
@Produces({"application/yaml", MediaType.TEXT_PLAIN})
public class YamlEntityProvider<T> implements MessageBodyWriter<T>, MessageBodyReader<T> {
    @Context
    private Providers providers;

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
                              MediaType mediaType) {
        return true;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                      MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        ContextResolver<YamlContext> cr = providers.getContextResolver(YamlContext.class, mediaType);
        YamlContext context = cr.getContext(type);
        T t = context.readEntity(entityStream, type);
        return t;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
                               MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(T t, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException, WebApplicationException {
        ContextResolver<YamlContext> cr = providers.getContextResolver(YamlContext.class, mediaType);
        YamlContext context = cr.getContext(type);
        context.writeEntity(entityStream, t);

    }
}