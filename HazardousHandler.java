public class HazardousHandler implements WasteHandler {
    private WasteHandler next;

    @Override
    public void setNext(WasteHandler next) {
        this.next = next;
    }

    @Override
    public void collect(WasteContainer c) {
        if (c.getType().equals("hazardous")) {
            System.out.println("HAZARDOUS UNIT → " + c.getLocation() +
                               " (" + c.getFillLevel() + "%) → special facility");
        }
        else if (next != null) {
            next.collect(c);
        }
        else {
            System.out.println("No handler found for: " + c.getLocation() + " (" + c.getType() + ")");
        }
    }
}