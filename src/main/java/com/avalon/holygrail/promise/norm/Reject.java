package com.avalon.holygrail.promise.norm;

/**
 * 失败
 * Created by 白超 on 2018/2/10.
 */
@FunctionalInterface
public interface Reject<T> {

    void accept(T err);
}
