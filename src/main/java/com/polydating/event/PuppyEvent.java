package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class PuppyEvent implements Event {

    @Override
    public String getTitle() {
        return "🐶 귀여운 강아지가 지나갔어요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {

        System.out.println("데이트 중 귀여운 강아지가 꼬리를 흔들며 다가왔습니다!");
        System.out.println();
        System.out.println("1. \"너무 귀엽다!\" 하며 강아지를 쓰다듬습니다.");
        System.out.println("2. 상대방에게 먼저 양보합니다.");
        System.out.println("3. 별 반응 없이 지나칩니다.");
        System.out.print("어떻게 하시겠습니까? : ");

        int choice = getValidInput(scanner);
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println(target.getNickname() + ": 후후, 진짜 귀엽네요.");
                state.setFavorability(state.getFavorability() + 8);
                break;

            case 2:
                System.out.println(target.getNickname() + ": 먼저 보라고 해주는 거... 은근 다정하시네요.");
                state.setFavorability(state.getFavorability() + 15);
                break;

            case 3:
                System.out.println(target.getNickname() + ": 강아지 안 좋아하세요...?");
                state.setAnnoyance(state.getAnnoyance() + 10);
                break;
        }
    }
}