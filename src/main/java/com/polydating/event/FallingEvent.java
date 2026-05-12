package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class FallingEvent implements Event {

    @Override
    public String getTitle() {
        return "😱 상대방이 넘어질 뻔 했어요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {

        System.out.println("걷던 중 상대방이 턱에 걸려 중심을 잃었습니다!");
        System.out.println();
        System.out.println("1. 재빨리 손을 붙잡아 넘어지는 걸 막는다.");
        System.out.println("2. \"괜찮아요?!\" 하며 놀라서 다가간다.");
        System.out.println("3. 웃음을 터뜨리며 \"조심하세요\" 라고 한다.");
        System.out.print("선택 : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println(">>> 순간 가까워진 거리. 자연스러운 스킨십으로 설레는 분위기가 생겨납니다.");
                state.setFavorability(state.getFavorability() + 20);
                break;

            case 2:
                System.out.println(target.getNickname() + ": 괜찮아요! 그래도 챙겨줘서 고마워요.");
                state.setFavorability(state.getFavorability() + 10);
                break;

            case 3:
                System.out.println(target.getNickname() + ": 지금 이 상황이 웃겨요?");
                System.out.println(">>> 분위기가 싸늘해졌습니다.");
                state.setAnnoyance(state.getAnnoyance() + 18);
                break;
        }
    }
}