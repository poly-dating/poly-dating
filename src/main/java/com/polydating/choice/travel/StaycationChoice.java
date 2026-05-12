package com.polydating.choice.travel;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class StaycationChoice implements Choice {
    @Override
    public String getTitle() {
        return "힐링 그 자체! 시원한 호텔에서 즐기는 북캉스";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여행: 호캉스는 역시 유유자적하게 북캉스죠!");
        if (target.getName().equals("Introvert")) {
            System.out.println(target.getNickname() + ": 에어컨 밑에서 책 읽기라니... 여기가 바로 천국인가 봐요.");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("GymBro")) {
            System.out.println(target.getNickname() + ": 책도 좋지만 호텔 헬스장 시설이 어떤지 궁금해서 잠이 안 오네요.");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getNickname() + ": 가끔은 아무것도 안 하고 푹 쉬는 여행도 너무 좋아요.");
            state.setFavorability(state.getFavorability() + 10);
        }
    }
}