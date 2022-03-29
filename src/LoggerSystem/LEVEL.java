package LoggerSystem;

public enum LEVEL {
    TRACE("TRACE"), SEVERE("SEVERE"), DEBUG("DEBUG");


    private final String value;

    LEVEL(String trace) {
        this.value = trace;
    }

    public String getValue() {
        return value;
    }
}