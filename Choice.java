public enum Choice {
    YES("yes"), NO("no");

    private final String description;

    Choice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
