abstract class AbstractClass {
    // abstract class kann wie jede Klasse aufgebaut werden
    // ABER: Kann nicht direkt ein Objekt erstellen.
    private int mimimi;
    public String secret = "Top Secret";

    public AbstractClass(){}

    public AbstractClass(int mimimi, String secret) {
        this.mimimi = mimimi;
        this.secret = secret;
    }

    public int getMimimi() {
        return mimimi;
    }

    public void setMimimi(int mimimi) {
        this.mimimi = mimimi;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
