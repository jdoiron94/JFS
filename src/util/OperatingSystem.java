package util;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public enum OperatingSystem {

    WINDOWS,
    LINUX,
    MAC,
    OTHER;

    /**
     * Gets the user's running operating system
     *
     * @return If found, the enum representing the current os; otherwise, <t>OTHER</t>
     */
    public static OperatingSystem getSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        for (OperatingSystem o : values()) {
            if (os.contains(o.toString().toLowerCase())) {
                return o;
            }
        }
        return OTHER;
    }
}
