package com.example.pinball.TheGame;

import com.example.pinball.commands.Command;
import com.example.pinball.commands.Commander;
import com.example.pinball.commands.RampCommand;
import com.example.pinball.elements.*;
import com.example.pinball.factories.DohFactory;
import com.example.pinball.factories.UniversFactory;
import com.example.pinball.medirator.Mediator;
import com.example.pinball.medirator.PinballMediator;
import com.example.pinball.status.NoCredit;
import com.example.pinball.status.Status;
import com.example.pinball.visitor.Counter;
import com.example.pinball.visitor.Reset;
import com.example.pinball.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameRound {

    private Pinball pinball = Pinball.getPinball();

    private boolean exit = false;
    private List<PinballElement> elements = new ArrayList<>();

    private Random random = new Random();

    Reset resetVisitor = new Reset();
    Counter counterVisitor = new Counter();
    Commander spinnerCommand1 = new Commander(pinball, resetVisitor, counterVisitor);
    Commander spinnerCommand2 = new Commander(pinball, resetVisitor, counterVisitor);
    Commander spinnerCommand3 = new Commander(pinball, resetVisitor, counterVisitor);

    Spinner spinner1 = new Spinner("SPINNER 1", spinnerCommand1);
    Spinner spinner2 = new Spinner("SPINNER 2", spinnerCommand2);
    Spinner spinner3 = new Spinner("SPINNER 3", spinnerCommand3);

    RampCommand rampCommand = new RampCommand(pinball);


    Commander commander = new Commander(pinball, resetVisitor, counterVisitor);
    List<Command> commandList = new ArrayList<>();

    Ramp ramp = new Ramp("THE RAMP", rampCommand);
    Hole hole = new Hole("THE HOLE", commander);
    Flipper rightFlipper = new Flipper("THE RIGHT FLIPPER");
    Flipper leftFlipper = new Flipper("THE LEFT FLIPPER");
    Kicker kicker1 = new Kicker("KICKER 1", commander);
    Kicker kicker2 = new Kicker("KICKER 2", commander);

    List<Bumper> bumpers = new ArrayList<>();
    Bumper bumper1 = new Bumper("BUMPER 1", commander);
    Bumper bumper2 = new Bumper("BUMPER 2", commander);
    Bumper bumper3 = new Bumper("BUMPER 3", commander);
    Bumper bumper4 = new Bumper("BUMPER 4", commander);

    List<Target> targets = new ArrayList<>();
    Target target1 = new Target("BUMPER 1", commander);
    Target target2 = new Target("BUMPER 2", commander);
    Target target3 = new Target("BUMPER 3", commander);
    Target target4 = new Target("BUMPER 4", commander);

    Mediator mediator = new PinballMediator(elements, ramp);

    public GameRound() {
    }

    public void setPinballElements () {

        commandList.add(spinnerCommand1);
        commandList.add(spinnerCommand2);
        commandList.add(spinnerCommand3);
        rampCommand.add(spinner1);
        rampCommand.add(spinner2);
        rampCommand.add(spinner3);

        elements.add(hole);
        elements.add(rightFlipper);
        elements.add(leftFlipper);
        elements.add(kicker1);
        elements.add(kicker2);
        bumpers.add(bumper1);
        bumpers.add(bumper2);
        bumpers.add(bumper3);
        bumpers.add(bumper4);
        elements.addAll(bumpers);
        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
        targets.add(target4);
        elements.addAll(targets);
        for (Target target : targets) {
            target.setMediator(mediator);
        }
    }

    public void styleChoice(Scanner scanner){
        boolean unavailableChoice = true;
        while (unavailableChoice) {
            System.out.print("YOUR CHOICE IS :\n");
            int factoryChoice = scanner.nextInt();
            if (factoryChoice == 1) {
                pinball.setFactory(new DohFactory());
                unavailableChoice = false;
            } else if (factoryChoice == 2) {
                pinball.setFactory(new UniversFactory());
                unavailableChoice = false;
            } else {
                System.out.println("PLEASE CHOOSE BETWEEN 1 OR 2");
                unavailableChoice = true;
            }
        }
    }
    public Status getGameStatus(){
        return pinball.getStatus();
    }

    public void getNoCreditAndReadyChoices(Scanner scanner) {
        System.out.println("YOUR CREDIT IS: " + pinball.getCredit());
        System.out.println("IF YOU WANNA ADD CREDIT PRESS -1-, PRESS -2- TO START THE GAME OR -3- TO LEAVE THE GAME.\n");
        boolean unavailableChoice = true;
        while (unavailableChoice) {
            int noCreditChoice = scanner.nextInt();
            if (noCreditChoice == 1) {
                pinball.getStatus().addCoin(pinball);
                unavailableChoice = false;
            } else if (noCreditChoice == 2) {
                pinball.getStatus().start(pinball);
                unavailableChoice = false;
            } else if (noCreditChoice == 3) {
                exit = true;
                unavailableChoice = false;
            }  else {
                System.out.println("PLEASE CHOOSE BETWEEN 1, 2 OR 3 !");
                unavailableChoice = true;
            }
        }
    }

    public void beforeFlipper(Scanner scanner) {
        System.out.println("TO FLIP PRESS -1-, PRESS -2- TO START THE GAME OR -3- TO ADD A COIN.\n");
        boolean notFlipper = true;
        while (notFlipper) {
            int beforeFlipperChoice = scanner.nextInt();
            if (beforeFlipperChoice == 1) {
                notFlipper = false;
            } else if (beforeFlipperChoice == 2) {
                pinball.getStatus().start(pinball);
            } else if (beforeFlipperChoice == 3) {
                pinball.getStatus().addCoin(pinball);
            }
        }
        useFlipper(scanner);

    }


    public void useFlipper(Scanner scanner) {
        boolean isFlipperOrHole = true;
        while (isFlipperOrHole) {
            int option = random.nextInt(9);
            if (!(elements.get(option) instanceof Hole) && !(elements.get(option) instanceof Flipper)) {
                isFlipperOrHole = false;
            }
        }
        elementGotHit(scanner);
    }

    public void elementGotHit(Scanner scanner) {
            int option = random.nextInt(8);
            elements.get(option).hit();
            if (elements.get(option) instanceof Flipper) {
                useFlipper(scanner);

        }
    }

}
