public class OrganicHandler implements WasteHandler {
    private WasteHandler next;

    @Override
    public void setNext(WasteHandler next) {
        this.next = next;
    }

    @Override
    public void collect(WasteContainer c) {
        if (c.getType().equals("organic")) {
            System.out.println("Organic truck → " + c.getLocation() +
                               " (" + c.getFillLevel() + "%) → to composting");
        }
        else if (next != null) {
            next.collect(c);
        }
        else {
            System.out.println("No handler found for: " + c.getLocation() + " (" + c.getType() + ")");
        }
    }
}