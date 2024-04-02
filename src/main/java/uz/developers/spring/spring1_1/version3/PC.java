package uz.developers.spring.spring1_1.version3;

public class PC {

    private String model;
    private float price;

    public PC(String model, float price) {
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
        return "PC{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
