package com.polydating.choice.activity;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class HanRiverBoatChoice implements Choice {
    @Override
    public String getTitle() {
        return "낭만 가득한 한강 오리배 타기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 액티비티: 한강에서 러브러브 오리배 대작전!");
        if (target.getName().equals("Extrovert")) {
            System.out.println(target.getNickname() + ": 바람도 시원하고 너무 좋다! 우리 인스타에 올릴까요?");
            state.setFavorability(state.getFavorability() + 10);
        } else if (target.getName().equals("GymBro")) {
            System.out.println(target.getNickname() + ": 이거 수동인가요? 제가 300RPM으로 밟아드릴게요.");
            state.setAnnoyance(state.getAnnoyance() + 5);
        } else {
            System.out.println(target.getNickname() + ": 낭만 가득한 한강이네요. 풍경이 참 예뻐요.");
            state.setFavorability(state.getFavorability() + 7);
        }
    }
}