package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class TableMannersEvent  implements Event {
    @Override
    public String getTitle() {
        return "🍽️ 식사 예절 문제";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("음식을 먹던 중 상대방이 당신의 식사 예절을 유심히 보고 있습니다.");
        System.out.println("1. 바른 자세로 천천히 먹습니다.");
        System.out.println("2. 맛있다며 신나게 먹습니다.");
        System.out.println("3. \"저 원래 이렇게 먹어요\" 라고 말합니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println(">>> 바른 식사 자세에 호감도가 상승합니다!");
                state.setFavorability(state.getFavorability() + 10);
                break;
            case 2:
                if (target.getName().equals("GymBro")) {
                    System.out.println(target.getNickname() + ": 너무 잘드시네요!! 단백질을 섭취하는 모습 보기 좋습니다.");
                    state.setFavorability(state.getFavorability() + 8);
                } else if (target.getName().equals("Introvert")){
                    System.out.println(target.getNickname() + ": (너무 게걸스럽네..)하하.. 잘 드시네요...");
                    state.setAnnoyance(state.getAnnoyance() + 8);
                } else {
                    System.out.println(target.getNickname() + ": 맛있게 드시는 모습이 끌릴지도..");
                    state.setAnnoyance(state.getFavorability() + 8);
                }
                break;
            case 3:
                System.out.println(target.getNickname() + ": 네... 예의가 ...아닙니다.");
                state.setAnnoyance(state.getAnnoyance() + 12);
                break;
        }
    }
}