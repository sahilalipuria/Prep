package com.logicbig.example;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface YamlContext {

    <T> T readEntity(InputStream entityStream, Class<T> type) throws IOException;

    void writeEntity(OutputStream entityStream, Object t) throws IOException;
}