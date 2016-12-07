package com.scame.parameterizedqueries.presenters;


public interface Presenter<T> {

    void setView(T view);

    void destroy();
}
