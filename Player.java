// Player.java
import java.util.*;

public class Player {
    private String name;
    private Room currentRoom;
    private int hp = 100;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getConnectedRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("이동 성공: " + currentRoom.getDescription());
        } else {
            System.out.println("그 방향으로는 갈 수 없습니다.");
        }
    }

    public void attack() {
        Monster monster = currentRoom.getMonster();
        if (monster == null) {
            System.out.println("여기엔 몬스터가 없습니다.");
            return;
        }

        int damage = (int)(Math.random() * 10) + 5;
        System.out.println("몬스터에게 " + damage + "의 데미지를 입혔습니다!");
        monster.takeDamage(damage);

        if (!monster.isAlive()) {
            System.out.println(monster.getName() + "을(를) 물리쳤습니다!");
            currentRoom.removeMonster();
        } else {
            int monsterDamage = monster.getAttackPower();
            hp -= monsterDamage;
            System.out.println(monster.getName() + "이(가) 반격하여 " + monsterDamage + "의 데미지를 입었습니다!");
            if (hp <= 0) {
                System.out.println("플레이어가 사망했습니다. 게임 오버.");
                System.exit(0);
            }
        }
    }

    public void pickUpItem() {
        Item item = currentRoom.getItem();
        if (item == null) {
            System.out.println("이 방에는 아이템이 없습니다.");
        } else {
            inventory.add(item);
            currentRoom.removeItem();
            System.out.println(item.getName() + "을(를) 인벤토리에 추가했습니다.");
        }
    }

    public void status() {
        System.out.println("이름: " + name);
        System.out.println("체력: " + hp);
        System.out.println("위치: " + currentRoom.getName());
        System.out.print("인벤토리: ");
        if (inventory.isEmpty()) {
            System.out.println("없음");
        } else {
            for (Item item : inventory) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }

        Monster monster = currentRoom.getMonster();
        if (monster != null) {
            System.out.println("※ 이 방에는 몬스터(" + monster.getName() + ")가 있습니다. HP: " + monster.getHp());
        }

        Item item = currentRoom.getItem();
        if (item != null) {
            System.out.println("※ 이 방에는 아이템(" + item.getName() + ")이 있습니다.");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void printAvailableDirections() {
        Set<String> directions = currentRoom.getAvailableDirections();
        if (directions.isEmpty()) {
            System.out.println("이동할 수 있는 방향이 없습니다.");
        } else {
            System.out.print("이동 가능한 방향: ");
            for (String dir : directions) {
                System.out.print(dir + " ");
            }
            System.out.println();
        }
    }
    
}