package com.polydating.choice.Hobby;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class CoinKaraokeChoice implements Choice {
    @Override
    public String getTitle() {
        return "스트레스 타파! 코인 노래방에서 열창하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여가생활: 코인 노래방에서 열창하기");
        if (target.getName().equals("Extrovert")) {
            System.out.println(target.getName() + ": 제 전공 분야네요! 마이크 제가 잡습니다. 첫 곡은 댄스곡!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Introvert")) {
            System.out.println(target.getName() + ": 저는 뒤에서 탬버린 칠게요... 노래 다 해주세요...");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getName() + ": 노래방 진짜 오랜만이에요! 잘 못 불러도 이해해 주세요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}