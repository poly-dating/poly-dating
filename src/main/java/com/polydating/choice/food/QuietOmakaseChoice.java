package com.polydating.choice.food;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class QuietOmakaseChoice implements Choice {
    @Override
    public String getTitle() {
        return "우리끼리 오붓하게, 조용한 스시 오마카세 즐기기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 메뉴: 서로 오붓하게 러브 오마카세 대작전!");
        if (target.getName().equals("Introvert")) {
            System.out.println(target.getName() + ": 조용하고 분위기가 너무 편안해요. 대화하기 딱 좋네요.");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Extrovert")) {
            System.out.println(target.getName() + ": 맛은 있는데... 너무 조용해서 크게 웃기가 좀 눈치 보여요.");
            state.setAnnoyance(state.getAnnoyance() + 5);
        } else {
            System.out.println(target.getName() + ": 이런 곳은 처음인데 분위기가 정말 좋네요.");
            state.setFavorability(state.getFavorability() + 10);
        }
    }
}