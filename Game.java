// Game.java
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player;
    private static MapManager mapManager;

    public static void main(String[] args) {
        mapManager = new MapManager();
        player = new Player("이영호", mapManager.getStartRoom());

        System.out.println("=== 자바 MUD 게임 ===");

        while (true) {
            System.out.print("\n명령 (이동/보기/공격/줍기/지도/종료): ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "이동":
                    player.printAvailableDirections(); // 추가된 부분
                    System.out.print("어느 방향? ");
                    String dir = scanner.nextLine().trim();
                    player.move(dir);
                    break;

                case "보기":
                    player.status();
                    break;
                case "공격":
                    player.attack();
                    break;
                case "줍기":
                    player.pickUpItem();
                    break;
                case "지도":
                    mapManager.printMap(player.getCurrentRoom());
                    break;
                case "종료":
                    System.out.println("게임 종료");
                    return;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
    }
} 