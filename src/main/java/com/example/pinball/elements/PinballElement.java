package com.example.pinball.elements;

import com.example.pinball.visitor.Visitor;

public interface PinballElement {

    void hit();
    void accept(Visitor visitor);
}
