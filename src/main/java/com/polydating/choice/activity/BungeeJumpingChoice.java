package com.polydating.choice.activity;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class BungeeJumpingChoice implements Choice {
    @Override
    public String getTitle() {
        return "스릴 만점! 커플 번지점프 하러 가기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 액티비티: 가평 번지점프 빠지 렛츠기릿");
        if (target.getName().equals("GymBro")) {
            System.out.println(target.getName() + ": 와! 이거 아드레날린 폭발하네요! 심박수 보니까 유산소 제대로 됩니다!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Introvert")) {
            System.out.println(target.getName() + ": ...꼭 뛰어내려야 하나요? 저는 가방 맡아드리면 안 될까요?");
            state.setAnnoyance(state.getAnnoyance() + 20);
        } else {
            System.out.println(target.getName() + ": 와, 진짜 높네요! 무섭긴 하지만 뛰어볼게요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}
