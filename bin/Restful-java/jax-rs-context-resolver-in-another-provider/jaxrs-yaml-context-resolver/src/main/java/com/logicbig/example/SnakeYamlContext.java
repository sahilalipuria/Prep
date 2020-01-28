package com.logicbig.example;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SnakeYamlContext implements YamlContext {
    @Override
    public <T> T readEntity(InputStream entityStream, Class<T> type) throws IOException {
        Yaml yaml = new Yaml();
        T t = yaml.loadAs(toString(entityStream), type);
        return t;
    }

    @Override
    public void writeEntity(OutputStream entityStream, Object t) throws IOException {

        Yaml yaml = new Yaml();
        OutputStreamWriter writer = new OutputStreamWriter(entityStream);
        yaml.dump(t, writer);
        writer.close();
    }

    private static String toString(InputStream inputStream) {
        return new Scanner(inputStream, "UTF-8")
                .useDelimiter("\\A").next();
    }
}