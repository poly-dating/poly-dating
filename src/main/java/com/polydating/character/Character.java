package com.polydating.character;

import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public abstract class Character {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void react(Choice choice, GameState state);
}