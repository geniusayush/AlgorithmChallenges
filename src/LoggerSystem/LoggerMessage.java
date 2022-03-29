package LoggerSystem;

public class LoggerMessage {
    Long date;
    String id;
    LEVEL level;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LEVEL getLevel() {
        return level;
    }

    public void setLevel(LEVEL level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoggerMessage(Long date, String id, LEVEL level, String message) {

        this.date = date;
        this.id = id;
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        return date +"";
    }

    String message;
}
