package com.polydating.run;

import com.polydating.character.*;
import com.polydating.character.Character;
import com.polydating.choice.Choice;
import com.polydating.choice.activity.*;
import com.polydating.choice.food.*;
import com.polydating.choice.hobby.*;
import com.polydating.choice.home.*;
import com.polydating.choice.travel.*;
import com.polydating.event.*;
import com.polydating.state.*;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameState state = new GameState();
        Map<String, List<Choice>> choicesByCategory = new LinkedHashMap<>();
        Set<String> usedChoices = new HashSet<>();

        choicesByCategory.put("🏃 액티비티", List.of(new BungeeJumpingChoice(), new HanRiverBoatChoice(), new ClimbingChoice()));
        choicesByCategory.put("🍔 음식", List.of(new HotPlaceBurgerChoice(), new MeatBuffetChoice(), new QuietOmakaseChoice()));
        choicesByCategory.put("🎯 취미", List.of(new CoinKaraokeChoice(), new EscapeRoomChoice(), new PlasticModelChoice()));
        choicesByCategory.put("🏠 집 데이트", List.of(new CoupleGameChoice(), new DeliveryFoodChoice(), new HorrorMovieChoice()));
        choicesByCategory.put("✈️ 여행", List.of(new JejuCyclingChoice(), new OceanTripChoice(), new StaycationChoice()));

        // 1. 캐릭터 선택
        Character character = null;
        while (character == null) {
            System.out.println("=== 💘 연애다항식 ===");
            System.out.println("1. 🏋️ 헬스남  2. 🎮 겜돌이  3. 😎 외향맨  4. 🌙 내향맨");
            System.out.print("상대를 선택하세요: ");
            int pick = getIntInput(sc, 1, 4);

            character = switch (pick) {
                case 1 -> { GymBro c = new GymBro(); c.setName("GymBro"); yield c; }
                case 2 -> { Gamer c = new Gamer(); c.setName("Gamer"); yield c; }
                case 3 -> { Extrovert c = new Extrovert(); c.setName("Extrovert"); yield c; }
                case 4 -> { Introvert c = new Introvert(); c.setName("Introvert"); yield c; }
                default -> throw new IllegalStateException("범위 밖 입력");
            };
        }

        System.out.println(character.getName() + "와(과) 데이트를 시작합니다!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("앞으로 당신에게 주어진 데이트 기회는 단 10번.");
        System.out.println("짧다면 짧고, 길다면 긴 이 시간 동안");
        System.out.println("상대의 마음을 사로잡아야 합니다.");
        System.out.println();
        System.out.println("설레는 연인이 될 수도,");
        System.out.println("좋은 친구로 남을 수도,");
        System.out.println("혹은 오늘 이후 다시 만나지 못할 수도 있습니다.");
        System.out.println();
        System.out.println("모든 결과는 당신의 선택과 행동에 달려 있습니다.");
        System.out.println("과연 당신의 엔딩은...?");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");


        // 2. 게임 루프 (최대 10턴)
        while (state.getConversationCount() < 10) {

            // 2-1. 현재 상태 출력
            System.out.println("=== " + (state.getConversationCount() + 1) + "턴 ===");
            System.out.println("❤️ 호감도: " + state.getFavorability() + " /  💢 불쾌도: " + state.getAnnoyance());

            // 2-2. 주제 선택
            List<String> categories = new ArrayList<>(choicesByCategory.keySet());
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i));
            }
            String selectedCategory = categories.get(getIntInput(sc, 1, categories.size()) - 1);

            List<Choice> available = choicesByCategory.get(selectedCategory).stream()
                    .filter(c -> !usedChoices.contains(c.getTitle()))
                    .collect(Collectors.toList());

            if (available.isEmpty()) {
                System.out.println("이 주제에 관한 모든 데이트를 완료했어요! 다른 주제를 골라주세요.");
                continue;
            }

            // 2-3. 데이트 선택
            for (int i = 0; i < available.size(); i++) {
                System.out.println((i + 1) + ". " + available.get(i).getTitle());
            }
            Choice selected = available.get(getIntInput(sc, 1, available.size()) - 1);
            usedChoices.add(selected.getTitle());   // 사용 처리

            selected.apply(character, state);
            character.react(selected, state);
            state.setConversationCount(state.getConversationCount() + 1);

            // 2-4. 엔딩 체크
            String ending = checkEnding(state);
            if (ending != null) {
                System.out.println("\n" + ending);
                sc.close();
                return;
            }
        }
        if (state.getFavorability() >= 60) {
            System.out.println("\n🤝 친구 엔딩! 좋은 친구가 됐어요.");
        } else {
            System.out.println("\n⏱ TIME OUT! 기회를 다 날렸네요...");
        }
        sc.close();
    }

    // 선택지 입력
    private static int getIntInput(Scanner sc, int min, int max) {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println(min + "~" + max + " 사이 숫자를 입력해주세요!");
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요!");
                sc.nextLine();
            }
        }
    }

    // 엔딩 체크
    private static String checkEnding(GameState state) {
        if (state.getAnnoyance() >= 70)    return "💔 상대방이 당신을 차단했습니다.";
        if (state.getFavorability() >= 90) return "💘 연인 엔딩!";
        return null;
    }
}
