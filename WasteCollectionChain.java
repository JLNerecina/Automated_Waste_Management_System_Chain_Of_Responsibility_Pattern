public class WasteCollectionChain {
    private WasteHandler firstHandler;

    public WasteCollectionChain() {
        WasteHandler organic   = new OrganicHandler();
        WasteHandler recycle   = new RecyclableHandler();
        WasteHandler hazard    = new HazardousHandler();
        WasteHandler general   = new GeneralHandler();

        organic.setNext(recycle);
        recycle.setNext(hazard);
        hazard.setNext(general);

        this.firstHandler = organic;
    }

    public void startCollection(WasteContainer container) {
        firstHandler.collect(container);
    }
}