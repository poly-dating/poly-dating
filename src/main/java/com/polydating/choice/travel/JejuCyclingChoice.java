package com.polydating.choice.travel;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class JejuCyclingChoice implements Choice {
    @Override
    public String getTitle() {
        return "에메랄드빛 바다 보며 제주도 자전거 일주하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여행: 떠나요~ 둘이서~ 모든걸 훌훌버리고~ 제주도 자전거 일주!");
        if (target.getName().equals("GymBro")) {
            System.out.println(target.getNickname() + ": 제주도 한 바퀴? 완전 가능하죠! 제 허벅지 엔진 믿으세요!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("Gamer")) {
            System.out.println(target.getNickname() + ": 저... 전동 킥보드 대여해 주는 곳은 없을까요? 다리가 후들거려요.");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getNickname() + ": 자전거 타고 바닷바람 맞으니까 가슴이 뻥 뚫리네요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}