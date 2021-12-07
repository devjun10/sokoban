import java.util.Objects;

public class StageInformation {

    private final int id;
    private final int height;
    private final int width;
    private final int maxValue;

    public StageInformation(int id, int height, int width) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.maxValue = getMaxValue();
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    protected int getMaxValue() {
        return height>width ? height : width;
    }

    public static void main(String[] args) throws Exception {
        StageInformation information = new StageInformation(1,2,3);
        System.out.println(information.getMaxValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StageInformation that = (StageInformation) o;
        return id == that.id && height == that.height && width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, width);
    }
}
