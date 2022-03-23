package com.example.pinball.commands;

import com.example.pinball.elements.PinballElement;

public interface Command {
    void execute(PinballElement element);
}
