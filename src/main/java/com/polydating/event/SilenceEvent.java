package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class SilenceEvent implements Event {
    @Override
    public String getTitle() {
        return "😳 어색한 침묵";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("대화가 뚝 끊기며 어색한 침묵이 흘렀습니다...");
        System.out.println("1. \"저 사실 좀 긴장했어요\" 라고 솔직하게 말합니다.");
        System.out.println("2. 스마트폰을 꺼내 재밌는 영상을 같이 봅니다.");
        System.out.println("3. 억지로 날씨 얘기를 꺼냅니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = getValidInput(scanner);
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println(">>> 솔직하시네요! 상대방의 호감도가 상승합니다.");
                state.setFavorability(state.getFavorability() + 12);
                break;
            case 2:
                if (target.getName().equals("Gamer")) {
                    System.out.println(target.getNickname() + ": 어 이거 제가 좋아하는 유튜번데!");
                    state.setFavorability(state.getFavorability() + 10);
                } else if (target.getName().equals("Extrovert")){
                    System.out.println(target.getNickname() + ": 저랑 이야기가 하기 싫으시군요..");
                    state.setAnnoyance(state.getAnnoyance() + 8);
                }
                break;
            case 3:
                System.out.println(target.getNickname() + ": 아..어....네.....");
                state.setAnnoyance(state.getAnnoyance() + 5);
                break;
        }
    }
}
