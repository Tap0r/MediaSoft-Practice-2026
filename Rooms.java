import java.util.Random;

enum Prices {
    ECONOMY(50),
    STANDARD(100),
    LUX(200),
    ULTRALUX(500);
    
    int price;
    Prices(int p) {
        price = p;
    }
}

abstract class Room {
    int number;
    int maxPeople;
    int pricePerNight;
    boolean isBooked;

    public Room(int number, int pricePerNight) {
        this.number = number;
        this.maxPeople = new Random().nextInt(4) + 1;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    @Override
    public String toString() { return number + " (" + getClass().getSimpleName() + ")"; }
}

class EconomyRoom extends Room {
    public EconomyRoom(int number) {
        super(number, Prices.ECONOMY.price);
    }
}

abstract class ProRoom extends Room {
    public ProRoom(int number, int pricePerNight) {
        super(number, pricePerNight);
    }
}

class StandartRoom extends ProRoom {
    public StandartRoom(int number) {
        super(number, Prices.STANDARD.price);
    }
}

class LuxRoom extends ProRoom {
    public LuxRoom(int number) {
        super(number, Prices.LUX.price);
    }
    public LuxRoom(int number, int pricePerNight) {
        super(number, pricePerNight);
    }
}

class UltraLuxRoom extends LuxRoom {
    public UltraLuxRoom(int number) {
        super(number, Prices.ULTRALUX.price);
    }
}
