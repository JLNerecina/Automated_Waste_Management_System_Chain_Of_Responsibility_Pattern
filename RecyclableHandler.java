public class RecyclableHandler implements WasteHandler {
    private WasteHandler next;

    @Override
    public void setNext(WasteHandler next) {
        this.next = next;
    }

    @Override
    public void collect(WasteContainer c) {
        if (c.getType().equals("recyclable")) {
            System.out.println("Recycling truck → " + c.getLocation() +
                               " (" + c.getFillLevel() + "%) → to MRF");
        }
        else if (next != null) {
            next.collect(c);
        }
        else {
            System.out.println("No handler found for: " + c.getLocation() + " (" + c.getType() + ")");
        }
    }
}