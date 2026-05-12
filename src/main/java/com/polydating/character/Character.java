package com.polydating.character;

import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public abstract class Character {

    private String name;    // 타입 구분용
    private String nickname;    // 출력용

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public abstract void react(Choice choice, GameState state);
}