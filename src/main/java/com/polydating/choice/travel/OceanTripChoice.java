package com.polydating.choice.travel;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class OceanTripChoice  implements Choice {
    @Override
    public String getTitle() {
        return "지금 바로 출발! 계획 없는 즉흥 강릉 바다 여행";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여행: 강릉 바다 구경하고 커피한잔~");
        if (target.getName().equals("Extrovert")) {
            System.out.println(target.getName() + ": 와! 이게 바로 청춘이죠! 지금 당장 알감자 먹으러 가요!");
            state.setFavorability(state.getFavorability() + 30);
        } else if (target.getName().equals("Introvert")) {
            System.out.println(target.getName() + ": 네? 지금 바로요? 보조배터리도 없는데 너무 불안해요...");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getName() + ": 즉흥 여행이라 더 설레네요. 바다 보니까 정말 시원해요!");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}