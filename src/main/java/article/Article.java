package article;

public class Article {
    private int id;
    private String subject;
    private String content;

    public Article(int id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    int getId() {
        return this.id;
    }

    String getSubject() {
        return this.subject;
    }

    String getContent() {
        return this.content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}