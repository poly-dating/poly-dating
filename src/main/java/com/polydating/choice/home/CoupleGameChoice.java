package com.polydating.choice.home;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class CoupleGameChoice  implements Choice {
    @Override
    public String getTitle() {
        return "집에서 편하게! 배달 음식 먹으며 커플 랭크 게임하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 집데이트: 롤 듀오 돌리기 가즈앗");
        if (target.getName().equals("Gamer")) {
            System.out.println(target.getNickname() + ": 제 주포지션 원딜인데, 서포터 해주시면 하드캐리 해드릴게요!");
            state.setFavorability(state.getFavorability() + 25);
        } else if (target.getName().equals("Introvert")) {
            System.out.println(target.getNickname() + ": 사람이 너무 많아서 조금 기가 빨려요... (PC방 이동 시)");
            state.setAnnoyance(state.getAnnoyance() + 10);
        } else {
            System.out.println(target.getNickname() + ": 게임은 잘 모르지만 가르쳐 주시면 열심히 해볼게요!");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}