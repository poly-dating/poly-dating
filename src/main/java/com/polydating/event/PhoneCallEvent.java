package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public class PhoneCallEvent implements Event {

    @Override
    public String getTitle() {
        return "📱 갑자기 전화가 걸려왔어요";
    }

    @Override
    public void apply(Character target, GameState state, Scanner scanner) {
        System.out.println("데이트 분위기가 무르익던 순간.");
        System.out.println("갑자기 당신의 휴대폰이 크게 울리기 시작합니다!");
        System.out.println();
        System.out.println("1. 급히 무음으로 바꾸고 \"죄송해요, 신경 쓰이셨죠?\"");
        System.out.println("2. \"잠깐이면 돼요!\" 하고 한쪽에서 길게 통화한다.");
        System.out.println("3. 휴대폰을 뒤집어두고 \"오늘은 당신한테만 집중하고 싶어요.\"");
        System.out.print("선택 : ");

        int choice = getValidInput(scanner);
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println(target.getNickname() + ": 아니에요, 매너가 참 좋으시네요.");
                state.setFavorability(state.getFavorability() + 12);
                break;

            case 2:
                System.out.println(">>> 통화는 5분... 10분... 점점 길어집니다.");
                state.setAnnoyance(state.getAnnoyance() + 20);
                break;

            case 3:
                if (target.getName().equals("Introvert")) {
                    System.out.println(target.getNickname() + ": 저에게 집중해주신다니 고맙네요...");
                    state.setFavorability(state.getFavorability() + 15);
                } else if (target.getName().equals("Extrovert")) {
                    System.out.println(target.getNickname() + ": 으악... 그런 멘트는 좀 부담스러운데요...");
                    state.setAnnoyance(state.getAnnoyance() + 12);
                }else {
                    System.out.println(target.getNickname() + "하하하. 참 재밌으시네요.");
                }
                break;
        }
    }
}
