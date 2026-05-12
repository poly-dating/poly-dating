package com.polydating.event;


import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class RainyEvent implements Event {
    @Override
    public String getTitle() {
        return "☔ 갑자기 비가 내려요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("갑자기 하늘에서 비가 쏟아지기 시작했습니다!");
        System.out.println("1. 재빨리 우산을 꺼내 같이 씁니다.");
        System.out.println("2. 근처 카페로 뛰어들어갑니다.");
        System.out.println("3. \"비 맞는 것도 낭만 아닌가요?\" 라고 말합니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println(">>> 자연스러운 스킨십 기회! 상대방의 어깨가 가까워집니다.");
                state.setFavorability(state.getFavorability() + 15);
                break;
            case 2:
                System.out.println(">>> 비를 피해 따뜻한 카페로 들어왔습니다.");
                state.setFavorability(state.getFavorability() + 8);
                break;
            case 3:
                if (target.getName().equals("GymBro") || target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 오, 이런 거 좋아해요! 시원하네요!");
                    state.setFavorability(state.getFavorability() + 10);
                } else {
                    System.out.println(target.getNickname() + ": 전 비 맞는 거 정말 싫어하는데...");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                }
                break;
        }
    }
}
