public interface WasteHandler {
    void setNext(WasteHandler next);
    void collect(WasteContainer container);
}