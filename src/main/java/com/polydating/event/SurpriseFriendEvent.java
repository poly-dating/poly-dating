package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class SurpriseFriendEvent implements Event {
    @Override
    public String getTitle() {
        return "👥 상대 친구가 나타났어요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("갑자기 상대방 친구가 지나가다 우릴 발견했습니다!");
        System.out.println("1. 먼저 반갑게 인사합니다.");
        System.out.println("2. 슬쩍 뒤로 물러나 상대방에게 맡깁니다.");
        System.out.println("3. \"오, 친구분이세요? 같이 합류할까요?\" 라고 제안합니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println(">>> 내 친구와 친하게 반갑게 인사하려는 모습에 호감도가 상승합니다!");
                state.setFavorability(state.getFavorability() + 10);
                break;
            case 2:
                if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 단 둘만의 시간을 방해받고 싶지 않았어요..!");
                    state.setFavorability(state.getFavorability() + 8);
                } else if (target.getName().equals("Extrovert")){
                    System.out.println(target.getNickname() + ": 제 친구를 피하시는 건가요..? 저와 사귀어도 같은 반응을 보이시겠군요..");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                } else {
                    System.out.println(target.getNickname() + ": 어엇.. 사실 저 친구랑 안 친해요...");
                    state.setAnnoyance(state.getAnnoyance() + 5);
                }
                break;
            case 3:
                if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 요 bro!! 빨리 들어오라구!!!");
                    state.setFavorability(state.getFavorability() + 15);
                } else if (target.getName().equals("Introvert")){
                    System.out.println(target.getNickname() + ": (아... 기빨린다) 하하 친구야 반가워.");
                    state.setAnnoyance(state.getAnnoyance() + 15);
                } else {
                    System.out.println(target.getNickname() + ": 단 둘만의 시간을 방해받고 싶지 않았어요..!");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                }
                break;
        }
    }
}