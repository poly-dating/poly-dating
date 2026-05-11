package com.polydating.choice.hobby;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class EscapeRoomChoice  implements Choice {
    @Override
    public String getTitle() {
        return "지능 풀가동! 고난이도 방탈출 카페 도전하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여가생활: 풀어봐요 방탈출 생활");
        if (target.getName().equals("Gamer")) {
            System.out.println(target.getName() + ": 퀘스트 난이도 별 5개네요. 제가 퍼즐 다 풀어드릴게요!");
            state.setFavorability(state.getFavorability() + 20);
        } else if (target.getName().equals("GymBro")) {
            System.out.println(target.getName() + ": 이거 그냥 힘으로 밀면 열릴 것 같은데... 안 된다고요?");
            state.setAnnoyance(state.getAnnoyance() + 15);
        } else {
            System.out.println(target.getName() + ": 팀워크로 한 번 탈출해 봐요! 머리 쓰는 재미가 있네요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}