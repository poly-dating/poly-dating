package com.polydating.choice.food;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class HotPlaceBurgerChoice implements Choice {
    @Override
    public String getTitle() {
        return "웨이팅 필수! 인스타 핫플 수제버거 맛집 가기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 메뉴: 고든 람세이 3만원 버거 대탐방~");
        if (target.getName().equals("Extrovert")) {
            System.out.println(target.getName() + ": 웨이팅 장난 아니네요! 기다리는 동안 우리 셀카 찍어요!");
            state.setFavorability(state.getFavorability() + 15);
        } else if (target.getName().equals("Introvert")) {
            System.out.println(target.getName() + ": 사람이 너무 많아서 기가 빨려요... 포장하면 안 될까요?");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getName() + ": 비주얼 대박이네요! 기다린 보람이 있는 맛이에요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}