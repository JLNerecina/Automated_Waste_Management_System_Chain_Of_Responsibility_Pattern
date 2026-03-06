public class WasteManagementDemo {
    public static void main(String[] args) {
        WasteCollectionChain system = new WasteCollectionChain();

        // Some example containers (only full ones should be collected)
        WasteContainer[] bins = {
            new WasteContainer("organic",    92, "Brgy Quezon Market"),
            new WasteContainer("recyclable", 65, "SM North EDSA"),
            new WasteContainer("hazardous",  88, "St. Luke's Hospital"),
            new WasteContainer("general",    91, "Laging Handa St."),
            new WasteContainer("organic",    45, "UP Diliman"),
            new WasteContainer("plastic",    89, "Mystery Bin")   // should fall through
        };

        System.out.println("Waste Collection Dispatch (85%+ full):\n");

        for (WasteContainer bin : bins) {
            if (bin.needsCollection()) {
                System.out.println("ALERT: " + bin.getLocation() +
                                   " - " + bin.getType() + " - " + bin.getFillLevel() + "%");
                system.startCollection(bin);
                System.out.println();
            }
        }
    }
}