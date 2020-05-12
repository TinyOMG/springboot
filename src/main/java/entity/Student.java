package entity;

public class Student {
    private String name;
    private String time;
    private String secret;


    public Student() {
    }

    public Student(String name, String time, String secret) {
        this.name = name;
        this.time = time;
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
