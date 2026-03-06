public class GeneralHandler implements WasteHandler {
    private WasteHandler next;

    @Override
    public void setNext(WasteHandler next) {
        this.next = next;
    }

    @Override
    public void collect(WasteContainer c) {
        if (c.getType().equals("general")) {
            System.out.println("Garbage truck → " + c.getLocation() +
                               " (" + c.getFillLevel() + "%) → landfill");
        }
        else if (next != null) {
            next.collect(c);
        }
        else {
            System.out.println("No handler found for: " + c.getLocation() + " (" + c.getType() + ")");
        }
    }
}