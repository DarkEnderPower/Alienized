package com.darkenderhilda.alienized.foundation.ui.elements.utils;

import com.darkenderhilda.alienized.foundation.ui.elements.AbstractElement;

import java.util.List;

public interface IParent<E extends AbstractElement<?>> {

    List<E> getElements();

    void acceptElement(E e);

    default void acceptElement(List<E> list) {
        list.forEach(this::acceptElement);
    }
}
