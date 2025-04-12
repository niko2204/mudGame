// MapManager.java
public class MapManager {
    private Room startRoom;

    public MapManager() {
        Room village = new Room("마을", "작은 시골 마을입니다. 여행의 시작점입니다.");
        Room forest = new Room("숲", "짙은 나무가 우거진 숲입니다.");
        Room cave = new Room("동굴", "어두운 동굴, 안쪽에서 울음소리가 들립니다.");
        Room mountain = new Room("산맥", "가파른 산들이 솟아있는 지역입니다.");
        Room desert = new Room("사막", "모래 바람이 거센 사막입니다.");
        Room lake = new Room("호수", "맑은 물이 고요한 호수입니다.");

        village.connectRoom("북", forest);
        village.connectRoom("남", desert);
        village.connectRoom("동", lake);
        forest.connectRoom("남", village);
        forest.connectRoom("서", cave);
        cave.connectRoom("동", forest);
        forest.connectRoom("북", mountain);
        mountain.connectRoom("남", forest);
        desert.connectRoom("북", village);
        lake.connectRoom("서", village);

        forest.setMonster(new Monster("고블린", 30, 5));
        cave.setMonster(new Monster("동굴 늑대", 40, 10));
        mountain.setMonster(new Monster("오우거", 60, 15));

        cave.setItem(new Item("회복 포션", "HP를 30 회복하는 포션"));
        lake.setItem(new Item("마법 반지", "특별한 능력을 지닌 반지"));
        desert.setItem(new Item("고대 동전", "고대 문명의 흔적"));

        this.startRoom = village;
    }

    public void printMap(Room currentRoom) {
        String loc = currentRoom.getName();
        String mountain = loc.equals("산맥") ? "[*산맥*]" : "[산맥]";
        String forest = loc.equals("숲") ? "[*숲*]" : "[숲]";
        String cave = loc.equals("동굴") ? "[*동굴*]" : "[동굴]";
        String village = loc.equals("마을") ? "[*마을*]" : "[마을]";
        String lake = loc.equals("호수") ? "[*호수*]" : "[호수]";
        String desert = loc.equals("사막") ? "[*사막*]" : "[사막]";

        System.out.println("\n=== 게임 지도 ===");
        System.out.println("       " + mountain);
        System.out.println("         |");
        System.out.println(cave + " — " + forest + " — " + village + " — " + lake);
        System.out.println("         |");
        System.out.println("       " + desert);
        System.out.println("\n※ 현재 위치는 *표시로 강조됩니다.");
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
