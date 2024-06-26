package com.chi.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGame")
public class SuperContraGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up - SuperContraGame");
    }

    @Override
    public void down() {
        System.out.println("down - SuperContraGame");
    }

    @Override
    public void left() {
        System.out.println("left - SuperContraGame");
    }

    @Override
    public void right() {
        System.out.println("right - SuperContraGame");
    }
    
}