package com.polydating.choice.home;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class DeliveryFoodChoice implements Choice {
    @Override
    public String getTitle() {
        return "오늘은 집콕! 마라탕이랑 엽떡 시켜 먹기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 집데이트: 역시 집데이트는 배달의 민족!");
        if (target.getName().equals("Introvert")) {
            System.out.println(target.getNickname() + ": 집이 최고죠! 마라탕이랑 꿔바로우 조합 센스 대박!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Extrovert")) {
            System.out.println(target.getNickname() + ": 편하긴 한데... 우리 이거 먹고 밤산책이라도 나갈까요?");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getNickname() + ": 밖은 위험해요. 맛있는 거 먹으면서 쉬는 게 최고네요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}