package progfun.collections.closures.complex;

/**
 * Created by PATEL1 on 1/24/15.
 */
public class Person {
    private String name;
    private JobType type;
    private MaritalStatus status;

    public Person(String name, JobType type, MaritalStatus status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public MaritalStatus getStatus() {
        return status;
    }

    public void setStatus(MaritalStatus status) {
        this.status = status;
    }

    @Override public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", type=" + type +
               ", status=" + status +
               '}';
    }
}
