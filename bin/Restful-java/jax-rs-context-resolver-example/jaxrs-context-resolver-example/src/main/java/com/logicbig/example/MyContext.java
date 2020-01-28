package com.logicbig.example;

public interface MyContext<T> {
    T get(String key);
}