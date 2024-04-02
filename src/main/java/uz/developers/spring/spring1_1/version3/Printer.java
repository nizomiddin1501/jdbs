package uz.developers.spring.spring1_1.version3;

public class Printer {

    private String model;
    private float price;


    public Printer(String model, float price) {
        this.model = model;
        this.price = price;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }






}
