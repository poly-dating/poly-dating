package com.polydating.choice;

import com.polydating.character.Character;
import com.polydating.state.GameState;

public interface Choice {

    String getTitle();

    void apply(Character target, GameState state);

}