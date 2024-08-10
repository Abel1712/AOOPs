import java.util.*;

// Main class
public class Q4A_AuctionHouse {
    public static void main(String[] args) {
        AuctionHouse h1 = new AuctionHouse("house A");
        AuctionHouse h2 = new AuctionHouse("house B");

        Bidders deadpool = new Bidders();
        Bidders ironman = new Bidders();

        System.out.println("List of houses:");
        for (MainAuctionhouse a : MainAuctionhouse.houses) {
            System.out.println(a.getHouseName());
        }

        deadpool.subscribe("house A");
        ironman.subscribe("house B");

        h1.sendItemNotification("Deadpool is back because he can never die");
        h2.sendItemNotification("Iron Man 4 coming soon");

        h1.sendTimingNotification(10, 12);
        h2.sendTimingNotification(1209, 123);

        deadpool.unsubscribe("house A");
    }
}

// Subject interface
interface MainAuctionhouse {
    String getHouseName();
    void add(Bidders b);
    void remove(Bidders b);
    void sendItemNotification(String str);
    void sendTimingNotification(int start, int end);

    List<MainAuctionhouse> houses = new ArrayList<>();
}

// Concrete Subject
class AuctionHouse implements MainAuctionhouse {
    private String houseName;
    private List<Bidders> biddersList = new ArrayList<>();

    AuctionHouse(String name) {
        this.houseName = name;
        houses.add(this);
    }

    @Override
    public String getHouseName() {
        return houseName;
    }

    @Override
    public void add(Bidders b) {
        biddersList.add(b);
    }

    @Override
    public void remove(Bidders b) {
        biddersList.remove(b);
    }

    @Override
    public void sendItemNotification(String str) {
        for (Bidders b : biddersList) {
            b.updateItemsList(str);
        }
    }

    @Override
    public void sendTimingNotification(int start, int end) {
        for (Bidders b : biddersList) {
            b.updateTimes(start, end);
        }
    }
}

// Observer interface
interface MainBidders {
    void updateTimes(int start, int end);
    void updateItemsList(String newItem);
}

// Concrete Observer
class Bidders implements MainBidders {
    private List<String> housesSubscribedTo = new ArrayList<>();
    private List<String> items = new ArrayList<>();

    @Override
    public void updateTimes(int start, int end) {
        System.out.println("New timings -> Start: " + start + ", End: " + end);
    }

    @Override
    public void updateItemsList(String newItem) {
        System.out.println("New item added: " + newItem);
        items.add(newItem);
    }

    public void subscribe(String houseName) {
        for (MainAuctionhouse a : MainAuctionhouse.houses) {
            if (a.getHouseName().equalsIgnoreCase(houseName)) {
                housesSubscribedTo.add(houseName);
                a.add(this);
                return;
            }
        }
        System.out.println("House not found: " + houseName);
    }

    public void unsubscribe(String houseName) {
        housesSubscribedTo.remove(houseName);
        for (MainAuctionhouse a : MainAuctionhouse.houses) {
            if (a.getHouseName().equalsIgnoreCase(houseName)) {
                a.remove(this);
                return;
            }
        }
        System.out.println("House not found: " + houseName);
    }
}
