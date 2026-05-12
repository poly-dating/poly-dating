package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class BuskingEvent implements Event {

    @Override
    public String getTitle() {
        return "🎵 거리에서 버스킹 공연이 열렸어요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {

        System.out.println("거리 한복판에서 신나는 버스킹 공연이 시작됐습니다!");
        System.out.println("사람들이 음악에 맞춰 박수를 치기 시작합니다.");
        System.out.println();
        System.out.println("1. \"우리 잠깐만 보고 갈래요?\" 하며 자연스럽게 멈춘다.");
        System.out.println("2. \"사람 너무 많다! 얼른 지나가죠.\" 하며 빠르게 지나간다.");
        System.out.println("3. 신나서 리듬 타면서 박수치고 분위기를 즐긴다.");
        System.out.print("선택 : ");

        int choice = getValidInput(scanner);
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println(">>> 감미로운 노래와 함께 데이트 분위기가 더욱 좋아졌습니다.");
                state.setFavorability(state.getFavorability() + 10);
                break;

            case 2:
                if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 솔직히 저도 사람 많은 데는 조금 힘들어요.");
                    state.setFavorability(state.getFavorability() + 5);
                } else if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 앗!! 공연 보고싶었는데 어쩔수 없죠.");
                    state.setAnnoyance(state.getAnnoyance() + 12);
                } else {
                    System.out.println(">>> 북적거리는 버스킹 장에서 무사히 빠져나왔습니다.");
                }
                break;

            case 3:
                if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 좋아요!! 이런 텐션 너무 재밌다!");
                    System.out.println(">>> 두사람은 함께 춤을 추며 사람들의 시선을 한 몸에 받습니다.");
                    state.setFavorability(state.getFavorability() + 15);
                } else if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 다... 다들 쳐다보는 것 같아요...");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                } else {
                    System.out.println(">>> 상대방도 박수를 치며 버스킹 공연을 함께 봅니다.");
                }
                break;
        }
    }
}