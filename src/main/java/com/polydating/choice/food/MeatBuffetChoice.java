package com.polydating.choice.food;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class MeatBuffetChoice implements Choice {
    @Override
    public String getTitle() {
        return "무한리필 삼겹살 조지기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 메뉴: 단백질이 폭발하는 고기 뷔페!");
        if (target.getName().equals("GymBro")) {
            System.out.println(target.getName() + ": 크으, 오늘 하체하고 왔는데 근성장 제대로네요!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Extrovert")) {
            System.out.println(target.getName() + ": 몸 관리해야 하는데 쓰읍.. 별론데요?");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getName() + ": 맛있네요! 근데 냄새가 좀 배겠어요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}