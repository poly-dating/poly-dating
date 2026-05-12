package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class SunsetEvent implements Event {

    @Override
    public String getTitle() {
        return "🌅 노을이 정말 예뻐요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {

        System.out.println("저녁이 되어 하늘이 노을로 붉게 물들기 시작했습니다.");
        System.out.println();
        System.out.println("1. \"잠깐 앉아서 노을 보고 갈래요?\"");
        System.out.println("2. 말없이 생각에 잠겨 노을을 바라본다.");
        System.out.println("3. \"잠깐만요, 인스타 사진 찍어드릴까요?\"");
        System.out.print("선택 : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println(">>> 노을빛 하늘 아래 점점 가까워지는 두 사람!!");
                state.setFavorability(state.getFavorability() + 12);
                break;

            case 2:
                if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 조용한 시간... 생각보다 되게 편안하네요.");
                    state.setFavorability(state.getFavorability() + 15);
                } else if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 너무 조용하면 제가 괜히 민망해져요!");
                    state.setAnnoyance(state.getAnnoyance() + 8);
                } else {
                    System.out.println(">>> 두 사람은 아름다운 노을을 함께 감상합니다.");
                }
                break;

            case 3:
                if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 좋아요!! 인생샷 각인데요?");
                    state.setFavorability(state.getFavorability() + 12);
                } else if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 사진이요..? 노을은 눈에 담을 때 가장 예쁜 거 같아요.");
                    state.setAnnoyance(state.getAnnoyance() + 10);
                } else {
                    System.out.println(target.getNickname() + ": 하하 전 괜찮습니다!");
                }
                break;
        }
    }
}