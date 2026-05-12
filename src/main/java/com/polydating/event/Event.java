package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

public interface Event {
    String getTitle();

    void apply(Character target, GameState state);
}
