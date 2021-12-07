public class Disk {
    private Init init = Init.of();

    private Disk() {};

    public static Disk of() {
        return new Disk();
    }
}
