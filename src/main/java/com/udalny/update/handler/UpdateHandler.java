package com.udalny.update.handler;

public interface UpdateHandler<T> {

    boolean probe(T doc);
    void update(T doc);
}
