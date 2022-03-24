package com.example.pinball;

import com.example.pinball.TheGame.GameRound;
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

        GameRound gameRound = new GameRound();
        Scanner scanner = new Scanner(System.in);
        gameRound.play(scanner);
    }
}