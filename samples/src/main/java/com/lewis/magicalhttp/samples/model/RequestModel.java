package com.lewis.magicalhttp.samples.model;

/**
 *
 */
public class RequestModel<T> {
    public int code;
    public T result;
    public T data;
    public String msg;
}
