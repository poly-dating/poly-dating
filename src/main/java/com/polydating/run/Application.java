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

        List<Event> eventList = new ArrayList<>();

        choicesByCategory.put("🏃 액티비티", List.of(new BungeeJumpingChoice(), new HanRiverBoatChoice(), new ClimbingChoice()));
        choicesByCategory.put("🍔 음식", List.of(new HotPlaceBurgerChoice(), new MeatBuffetChoice(), new QuietOmakaseChoice()));
        choicesByCategory.put("🎯 취미", List.of(new CoinKaraokeChoice(), new EscapeRoomChoice(), new PlasticModelChoice()));
        choicesByCategory.put("🏠 집 데이트", List.of(new CoupleGameChoice(), new DeliveryFoodChoice(), new HorrorMovieChoice()));
        choicesByCategory.put("✈️ 여행", List.of(new JejuCyclingChoice(), new OceanTripChoice(), new StaycationChoice()));

        eventList.add(new PaymentEvent());
        eventList.add(new RainyEvent());
        eventList.add(new SilenceEvent());
        eventList.add(new SurpriseFriendEvent());
        eventList.add(new TableMannersEvent());
        Collections.shuffle(eventList);

        // 1. 캐릭터 선택
        Character character = null;
        while (character == null) {
            System.out.println("=== 💘 연애다항식 ===");
            System.out.println("1. 🏋️ 헬스남  2. 🎮 겜돌이  3. 😎 외향맨  4. 🌙 내향맨");
            System.out.print("상대를 선택하세요: ");
            int pick = getIntInput(sc, 1, 4);

            character = switch (pick) {
                case 1 -> { GymBro c = new GymBro(); c.setName("GymBro"); c.setNickname("🏋️ 헬스남");yield c; }
                case 2 -> { Gamer c = new Gamer(); c.setName("Gamer"); c.setNickname("🎮 겜돌이"); yield c; }
                case 3 -> { Extrovert c = new Extrovert(); c.setName("Extrovert"); c.setNickname("😎 외향맨"); yield c; }
                case 4 -> { Introvert c = new Introvert(); c.setName("Introvert"); c.setNickname("🌙 내향맨"); yield c; }
                default -> throw new IllegalStateException("범위 밖 입력");
            };
        }

        System.out.println(character.getNickname() + "와(과) 데이트를 시작합니다!");
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
        boolean isEvent = false;
        while (state.getConversationCount() < 10) {

            // 이벤트 발생
            Random random = new Random();
            if (Math.random() < 0.3 && !eventList.isEmpty() && !isEvent) {
                System.out.println();
                int randomIndex = random.nextInt(eventList.size());

                Event selectedEvent = eventList.get(randomIndex);

                selectedEvent.apply(character, state, sc);
                eventList.remove(randomIndex);
                System.out.println();
                isEvent = true;
                continue;
            }

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
            isEvent = false;

            // 2-4. 엔딩 체크
            String ending = checkEnding(state, character);
            if (ending != null) {
                System.out.println("\n" + ending);
                sc.close();
                return;
            }
        }
        if (state.getFavorability() >= 60) {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🤝 친구 엔딩");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            System.out.println(character.getNickname() + "와(과)의 관계는");
            System.out.println("연인까지 이어지진 않았지만,");
            System.out.println("서로를 편하게 웃을 수 있는 특별한 친구가 되었습니다.");
            System.out.println();

            System.out.println(character.getNickname() + "은(는) 당신과 함께한 시간을");
            System.out.println("꽤 즐거운 추억으로 기억할 것 같습니다.");
            System.out.println();

            System.out.println("\"다음엔 그냥 편하게 놀러 나오자!\"");
            System.out.println("- " + character.getNickname());

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        } else {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("⏱ TIME OUT");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            System.out.println("10번의 데이트 기회가 모두 끝났습니다.");
            System.out.println();

            System.out.println(character.getNickname() + "의 마음은");
            System.out.println("끝내 당신에게 완전히 열리지 않았습니다.");
            System.out.println();

            System.out.println("조금 더 용기냈더라면,");
            System.out.println("조금 더 솔직했더라면");
            System.out.println("결말은 달라졌을지도 모릅니다.");

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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
    private static String checkEnding(GameState state, Character character) {
        if (state.getAnnoyance() >= 70) {

            return """
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                💔 차단 엔딩
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                %s은(는) 결국 당신에게 마음의 문을 닫았습니다.
                
                반복된 실수와 어긋난 선택들.
                장난처럼 넘겼던 순간들은
                상대에겐 상처로 남아버렸습니다.
                
                "%s : ...더이상의 만남은 무의미한 것 같네요.
                앞으로는 연락하지 말아주세요."
                
                연락창은 조용히 닫혔고,
                더 이상 답장은 오지 않았습니다.
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """.formatted(character.getNickname(),
                    character.getNickname());
        }
        if (state.getFavorability() >= 90) {

            return """
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                💘 연인 엔딩
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                수많은 선택 끝에,
                당신은 결국 %s의 마음을 사로잡았습니다.
                
                함께 웃고,
                함께 설레고,
                서로를 조금씩 알아가던 시간들.
                
                그 모든 순간은
                두 사람을 특별한 관계로 이어주었습니다.
                
                "%s : 앞으로도... 내 옆에 있어줄래요?"
                
                그렇게 두 사람의 이야기는
                새로운 시작을 맞이하게 됩니다.
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """.formatted(character.getNickname(),
                    character.getNickname());
        }
        return null;
    }
}
