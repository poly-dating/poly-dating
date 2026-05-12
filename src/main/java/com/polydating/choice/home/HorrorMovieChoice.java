package com.polydating.choice.home;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class HorrorMovieChoice implements Choice {
    @Override
    public String getTitle() {
        return "심장 쫄깃! 불 끄고 공포영화 정주행하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 집데이트: 살목지 곤지암 정주행 으스스...");
        if (target.getName().equals("Introvert")) {
            System.out.println(target.getNickname() + ": 집에서 보니까 하나도 안 무서워요. (사실 손으로 눈 가리고 있음)");
            state.setFavorability(state.getFavorability() + 15);
        } else if (target.getName().equals("Extrovert")) {
            System.out.println(target.getNickname() + ": 좀이 쑤시는데... 나가면 안 될까요?");
            state.setAnnoyance(state.getAnnoyance() + 20);
        } else {
            System.out.println(target.getNickname() + ": 어우 깜짝이야! 은근 스릴 있네요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}