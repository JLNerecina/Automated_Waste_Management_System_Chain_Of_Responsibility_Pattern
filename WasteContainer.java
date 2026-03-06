public class WasteContainer {
    private String type;   // "organic", "recyclable", "hazardous", "general"
    private int fillLevel; // in percentage 
    private String location;

    public WasteContainer(String type, int fillLevel, String location) {
        this.type = type.toLowerCase();
        this.fillLevel = fillLevel;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public String getLocation() {
        return location;
    }

    public boolean needsCollection() {
        return fillLevel >= 85;
    }
}