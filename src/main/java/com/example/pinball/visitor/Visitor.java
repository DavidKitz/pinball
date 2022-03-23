package com.example.pinball.visitor;

import com.example.pinball.elements.*;

public interface Visitor {

    void visit(Bumper bumper);
    void visit(Flipper flipper);
    void visit(Hole hole);
    void visit(Kicker kicker);
    void visit(Ramp ramp);
    void visit(Spinner spinner);
    void visit(Target target);
}
