package animalshelter;

import java.time.LocalDateTime;

public class Animal {
    String name;
    String type;
    LocalDateTime arrivalTime;

    public Animal(String name, String type, LocalDateTime arrivalTime) {
        this.name = name;
        this.type = type;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
}
