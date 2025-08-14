class Ring {
    // Instance variables for center coordinates and radius
    private int xCenter, yCenter;
    private double radius;

    // Constructor to initialize the ring
    public Ring(int x, int y, double r) {
        this.xCenter = x;
        this.yCenter = y;
        this.radius = r;
    }

    // Method to get the center X coordinate
    public int getXCenter() {
        return xCenter;
    }

    // Method to get the center Y coordinate
    public int getYCenter() {
        return yCenter;
    }

    // Method to get the radius
    public double getRadius() {
        return radius;
    }

    // Method to calculate the area of the ring (circle)
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Method to display ring information
    public void showDetails() {
        System.out.println("Ring Center: (" + xCenter + ", " + yCenter + ")");
        System.out.println("Radius: " + radius);
        System.out.println("Area of the Ring: " + calculateArea());
    }

    // Method to determine if a point is inside or outside the ring
    public String assessPosition(int x, int y) {
        double dist = Math.hypot(x - xCenter, y - yCenter);
        return (dist <= radius) ? "INSIDE" : "OUTSIDE";
    }
}

public class Match {
    public static void main(String[] args) {
        // Create a Ring object
        Ring ring = new Ring(0, 0, 10);

        // Display ring details
        ring.showDetails();

        // Define positions for two participants
        int[][] participants = {{2, 3}, {11, 6}};

        // Check positions of participants
        for (int i = 0; i < participants.length; i++) {
            String result = ring.assessPosition(participants[i][0], participants[i][1]);

            // Enhanced switch case to handle the result
            switch (result) {
                case "INSIDE":
                    System.out.println("Participant " + (i + 1) + " is within the ring: WINNING!");
                    break;
                case "OUTSIDE":
                    System.out.println("Participant " + (i + 1) + " is outside the ring: LOSING!");
                    break;
                default:
                    System.out.println("Participant " + (i + 1) + " position is undetermined.");
                    break;
            }
        }
    }
}
