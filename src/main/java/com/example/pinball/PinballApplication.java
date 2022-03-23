package com.example.pinball;

import com.example.pinball.TheGame.Pinball;
import com.example.pinball.commands.Command;
import com.example.pinball.commands.Commander;
import com.example.pinball.commands.RampCommand;
import com.example.pinball.elements.*;
import com.example.pinball.factories.*;
import com.example.pinball.medirator.Mediator;
import com.example.pinball.medirator.PinballMediator;
import com.example.pinball.status.NoCredit;
import com.example.pinball.status.Playing;
import com.example.pinball.status.Ready;
import com.example.pinball.visitor.Counter;
import com.example.pinball.visitor.Reset;
import com.example.pinball.visitor.Visitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class PinballApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinballApplication.class, args);

        Pinball pinball = new Pinball(new NoCredit());
        List<PinballElement> elements = new ArrayList<>();

        Reset resetVisitor = new Reset();
        Counter counterVisitor = new Counter();
        Commander spinnerCommand1 = new Commander(pinball, resetVisitor, counterVisitor);
        Commander spinnerCommand2 = new Commander(pinball, resetVisitor, counterVisitor);
        Commander spinnerCommand3 = new Commander(pinball, resetVisitor, counterVisitor);
        Spinner spinner1 = new Spinner("SPINNER 1", spinnerCommand1);
        Spinner spinner2 = new Spinner("SPINNER 2", spinnerCommand2);
        Spinner spinner3 = new Spinner("SPINNER 3", spinnerCommand3);

        RampCommand rampCommand = new RampCommand(pinball);
        rampCommand.add(spinner1);
        rampCommand.add(spinner2);
        rampCommand.add(spinner3);

        Commander commander = new Commander(pinball, resetVisitor, counterVisitor);

        List<Command> commandList = new ArrayList<>();
        commandList.add(spinnerCommand1);
        commandList.add(spinnerCommand2);
        commandList.add(spinnerCommand3);

        Ramp ramp = new Ramp("THE RAMP", rampCommand);

        Hole hole = new Hole("THE HOLE", commander);
        Flipper rightFlipper = new Flipper("THE RIGHT FLIPPER");
        Flipper leftFlipper = new Flipper("THE LEFT FLIPPER");
        Kicker kicker1 = new Kicker("KICKER 1", commander);
        Kicker kicker2 = new Kicker("KICKER 2", commander);
        elements.add(hole);
        elements.add(rightFlipper);
        elements.add(leftFlipper);
        elements.add(kicker1);
        elements.add(kicker2);

        List<Bumper> bumpers = new ArrayList<>();
        Bumper bumper1 = new Bumper("BUMPER 1", commander);
        Bumper bumper2 = new Bumper("BUMPER 2", commander);
        Bumper bumper3 = new Bumper("BUMPER 3", commander);
        Bumper bumper4 = new Bumper("BUMPER 4", commander);
        bumpers.add(bumper1);
        bumpers.add(bumper2);
        bumpers.add(bumper3);
        bumpers.add(bumper4);
        elements.addAll(bumpers);

        List<Target> targets = new ArrayList<>();
        Target target1 = new Target("BUMPER 1", commander);
        Target target2 = new Target("BUMPER 2", commander);
        Target target3 = new Target("BUMPER 3", commander);
        Target target4 = new Target("BUMPER 4", commander);
        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
        targets.add(target4);
        elements.addAll(targets);

        Mediator mediator = new PinballMediator(elements, ramp);
        for (Target target : targets) {
            target.setMediator(mediator);
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("WELCOME TO THE GAME! \n");
            System.out.println("CHOOSE HOW TO SEE YOUR GAME STYLE:");
            Ball ball1 = new Ball1();
            Ball ball12 = new Ball12();
            System.out.println(ball1.showBall());
            System.out.println("*********************** OR ***********************");
            System.out.println(ball12.showBall());

            styleChoice(scanner, pinball);


            if (pinball.getStatus() == new NoCredit()) {
                System.out.println("YOUR CREDIT IS: " + pinball.getCredit());
                System.out.println("IF YOU WANNA ADD CREDIT PRESS -1-, PRESS -2- TO START THE GAME OR -3- TO LEAVE THE GAME.\n");
                int noCreditChoice = scanner.nextInt();
                boolean unavailableChoice = true;
                while (unavailableChoice) {
                    if (noCreditChoice == 1) {
                        pinball.getStatus().addCoin(pinball);
                        unavailableChoice = false;
                    } else if (noCreditChoice == 2) {
                        pinball.getStatus().start(pinball);
                        unavailableChoice = false;
                    } else if (noCreditChoice == 3) {
                        exit = true;
                        unavailableChoice = false;
                    } else {
                        System.out.println("PLEASE CHOOSE BETWEEN 1, 2 OR 3 !");
                        unavailableChoice = true;
                    }
                }
            } else if (pinball.getStatus() == new Ready()) {
                System.out.println("READY TO PLAY, YOU HAVE " + pinball.getCredit() + " CREDIT(S)");
                System.out.println("IF YOU WANNA ADD CREDIT PRESS -1-, PRESS -2- TO START THE GAME OR -3- TO LEAVE THE GAME.\n");
                int noCreditChoice = scanner.nextInt();
                boolean unavailableChoice = true;
                while (unavailableChoice) {
                    if (noCreditChoice == 1) {
                        pinball.getStatus().addCoin(pinball);
                        unavailableChoice = false;
                    } else if (noCreditChoice == 2) {
                        pinball.getStatus().start(pinball);
                        unavailableChoice = false;
                    } else if (noCreditChoice == 3) {
                        exit = true;
                        unavailableChoice = false;
                    } else {
                        System.out.println("PLEASE CHOOSE BETWEEN 1, 2 OR 3 !");
                        unavailableChoice = true;
                    }
                }
            } else if (pinball.getStatus() == new Playing()) {
                pinball.setBalls(pinball.getBalls() - 1);
                System.out.println("YOU HAVE " + pinball.getCredit());
                if (pinball.getBalls() == 2) {
                    System.out.println(pinball.getFactory().createBall1());
                } else if (pinball.getBalls() == 1) {
                    System.out.println(pinball.getFactory().createBall2());
                } else if (pinball.getBalls() == 0) {
                    System.out.println(pinball.getFactory().createBall3());
                }
                Random random = new Random();
                int option1 = random.nextInt(11);
                if (option1 == 1) {
                    kicker1.getHits();
                    int option2 = random.nextInt(3);
                    if (option2 == 0) {
                        rightFlipper.hit();
                    } else if (option2 == 1) {
                        hole.hit();
                        System.out.println(pinball.getFactory().createGameOver());
                    } else if (option2 == 2) {
                        leftFlipper.hit();
                    }
                }

            }






        }



    }

    public static void styleChoice(Scanner scanner, Pinball pinball){
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

}