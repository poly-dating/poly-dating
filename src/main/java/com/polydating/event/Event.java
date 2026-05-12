package com.polydating.event;

import com.polydating.character.Character;
import com.polydating.state.GameState;

import java.util.Scanner;

public interface Event {
    String getTitle();

    void apply(Character target, GameState state, Scanner scanner);

    default int getValidInput(Scanner sc) {
        int choice;
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("❌ 숫자만 입력 가능합니다!");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                return choice;
            } else {
                System.out.println("⚠️ 1~3 사이의 숫자를 입력해주세요!");
            }
        }
    }
}
