import java.util.Objects;

public class Task {
    private long id;
    private String message;
    private String date;

    public Task(long id, String message, String date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Message: " + message + ", Date: " + date;
    }
}
