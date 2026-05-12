package com.polydating.choice.hobby;

import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.state.GameState;

public class PlasticModelChoice implements Choice {
    @Override
    public String getTitle() {
        return "집중력 대결! 카페에서 같이 프라모델 조립하기";
    }

    @Override
    public void apply(Character target, GameState state) {
        System.out.println(">>> 여가생활: 카페에서 프라모델 조립하기");
        if (target.getName().equals("Gamer")) {
            System.out.println(target.getNickname() + ": 와! 이거 한정판 아닌가요? 파츠 다듬는 손길이 예사롭지 않으시네요!");
            state.setFavorability(state.getFavorability() + 15);
        } else if (target.getName().equals("Extrovert")) {
            System.out.println(target.getNickname() + ": 30분째 한마디도 안 하고 이것만 만드니 좀 심심한 것 같아요.");
            state.setAnnoyance(state.getAnnoyance() + 10);
        } else {
            System.out.println(target.getNickname() + ": 집중하다 보니 잡생각이 사라지네요. 힐링 되는 기분이에요.");
            state.setFavorability(state.getFavorability() + 5);
        }
    }
}