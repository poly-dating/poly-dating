package com.polydating.choice.activity;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class ClimbingChoice implements Choice {
    @Override
    public String getTitle() {
        return "땀 흘리며 친해지는 실내 클라이밍 데이트";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 액티비티: 클라이밍은 역시 근성장이죠!");
        if (target.getName().equals("GymBro")) {
            System.out.println(target.getNickname() + ": 전완근 털릴 준비 되셨나요? 제가 빌레이 봐드릴게요!");
            state.setFavorability(state.getFavorability() + 15);
        } else if (target.getName().equals("Gamer")) {
            System.out.println(target.getNickname() + ": 제 스테미나 바가 벌써 빨간색이에요... 리젠이 필요합니다.");
            state.setAnnoyance(state.getAnnoyance() + 10);
        } else {
            System.out.println(target.getNickname() + ": 내일 근육통 오는 거 아니겠죠? 일단 가보시죠!");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}