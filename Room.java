// Room.java
import java.util.*;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> connections = new HashMap<>();
    private Monster monster;
    private Item item;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<String> getAvailableDirections() {
        return connections.keySet();
    }
    
    public void connectRoom(String direction, Room room) {
        connections.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connections.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void removeMonster() {
        this.monster = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void removeItem() {
        this.item = null;
    }
}