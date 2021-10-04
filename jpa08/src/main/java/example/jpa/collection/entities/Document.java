package example.jpa.collection.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Document {
    private String number;
    private String reference;

    public Document() {
    }

    public Document(String number, String reference) {
        this.number = number;
        this.reference = reference;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
