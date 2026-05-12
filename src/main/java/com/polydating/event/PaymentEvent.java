package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class PaymentEvent implements Event {
    @Override
    public String getTitle() {
        return " 💳 계산 상황";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("식사가 끝나고 계산서가 나왔습니다.");
        System.out.println("1. 먼저 카드를 꺼냅니다.");
        System.out.println("2. \"더치페이 어때요?\" 라고 제안합니다.");
        System.out.println("3. 잠깐 머뭇거립니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = getValidInput(scanner);
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println(">>> 오늘은 사주시는 건가요? 잘 먹었습니다!");
                state.setFavorability(state.getFavorability() + 15);
                break;
            case 2:
                if (target.getName().equals("Gamer") || target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 더치페이 좋습니다!");
                    state.setFavorability(state.getFavorability() + 8);
                } else if (target.getName().equals("GymBro")){
                    System.out.println(target.getNickname() + ": 제가 사드리는 게 좋은데요..");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                } else {
                    System.out.println(target.getNickname() + ": 더치페이... 제가 사드리는 게 좋은데요..");
                    state.setFavorability(state.getAnnoyance() + 8);
                }
                break;
            case 3:
                System.out.println(target.getNickname() + ": 저에게 식사계산하는 것이 아까우신 거군요..");
                state.setAnnoyance(state.getAnnoyance() + 10);
                break;
        }
    }
}
