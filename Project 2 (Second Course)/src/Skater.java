import java.lang.Double;

public final class Skater  {
    private final String skaterName;
    private final String skaterClub;
    private final double shortProgram;
    private final double longProgram;
    private final double programComponent;
    private final double executedElement;

    public Skater(String skaterName, String skaterClub, double shortProgram, double longProgram, double programComponent, double executedElement) {
        this.skaterName = skaterName;
        this.skaterClub = skaterClub;
        this.shortProgram = shortProgram;
        this.longProgram = longProgram;
        this.programComponent = programComponent;
        this.executedElement = executedElement;
    }

    public String getSkaterName() {
        return skaterName;
    }

    public String getSkaterClub() {
        return skaterClub;
    }

    public double getShortProgram() {
        return shortProgram;
    }

    public double getLongProgram() {
        return longProgram;
    }

    public double getProgramComponent() {
        return programComponent;
    }

    public double getExecutedElement() {
        return executedElement;
    }




}
