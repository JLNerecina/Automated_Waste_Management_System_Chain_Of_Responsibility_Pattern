# Automated Waste Management System  
**Chain of Responsibility Pattern – Java**

A simple simulation of an automated waste collection dispatch system using the **Chain of Responsibility** design pattern.  
The system checks waste containers and dispatches the appropriate collection truck based on waste type.

## Features

- Supports four main waste types:  
  - Organic  
  - Recyclable  
  - Hazardous  
  - General (fallback)  
- Only containers ≥ **85% full** trigger collection  
- Clean, easy-to-extend chain of responsibility implementation  
- No enums, no abstract classes – beginner-friendly structure  
- Similar style to classic ATM dispense examples

## Project Structure

```
WasteManagementDemo.java       → Main demo / entry point
WasteContainer.java            → Represents a waste bin
WasteHandler.java              → Interface for handlers
WasteCollectionChain.java      → Sets up the chain
OrganicHandler.java
RecyclableHandler.java
HazardousHandler.java
GeneralHandler.java            → Concrete handlers
```
## Class Diagram

![image]()

## How It Works

1. **WasteContainer** holds type, fill level (%), and location  
2. **WasteCollectionChain** creates the chain:  
   Organic → Recyclable → Hazardous → General  
3. When a container is ≥ 85% full, the request is passed along the chain  
4. The matching handler prints the dispatch message  
5. Unknown types fall through to the end (shows "No handler found")

## Sample Output

```
Waste Collection Dispatch (85%+ full):

ALERT: Brgy Quezon Market - organic - 92%
Organic truck → Brgy Quezon Market (92%) → to composting

ALERT: St. Luke's Hospital - hazardous - 88%
HAZARDOUS UNIT → St. Luke's Hospital (88%) → special facility

ALERT: Laging Handa St. - general - 91%
Garbage truck → Laging Handa St. (91%) → landfill

ALERT: Mystery Bin - plastic - 89%
No handler found for: Mystery Bin (plastic)
```

## How to Run

1. Make sure you have **Java 8+** installed
2. Put all `.java` files in the same folder
3. Compile:
   ```bash
   javac *.java
   ```
4. Run:
   ```bash
   java WasteManagementDemo
   ```

## How to Extend

Add a new waste type in 3 easy steps:

1. Create new handler class (copy any existing one):

```java
public class GlassHandler implements WasteHandler {
    private WasteHandler next;
    @Override public void setNext(WasteHandler n) { this.next = n; }
    @Override public void collect(WasteContainer c) {
        if (c.getType().equals("glass")) {
            System.out.println("Glass truck → " + c.getLocation() + " ...");
        } else if (next != null) {
            next.collect(c);
        }
    }
}
```

2. In `WasteCollectionChain` constructor, add it to the chain:

```java
WasteHandler glass = new GlassHandler();
recycle.setNext(glass);   // or wherever you want it in the order
glass.setNext(hazard);
```

3. Use the new type in containers:

```java
new WasteContainer("glass", 87, "Bottle Depot");
```

## Why Chain of Responsibility?

- Clean separation of responsibility per waste type  
- Easy to add/remove handlers without changing existing code  
- Request passes naturally until handled (or falls through)

## Requirements

- Java 8 or higher  
- No external libraries
