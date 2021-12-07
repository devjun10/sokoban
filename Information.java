import java.util.Objects;

public class Information {

    private final int height;
    private final int width;
    private final int maxValue;

    public Information(int height, int width, int maxValue) {
        this.height = height;
        this.width = width;
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return height == that.height && width == that.width && maxValue == that.maxValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, maxValue);
    }
}
