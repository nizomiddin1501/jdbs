package uz.developers.spring.spring1_1.version1;

public class Product {

    private Integer id;
    private String maker;
    private String model;
    private String type;

    public Product(Integer id, String maker, String model, String type) {
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.type = type;
    }

    public Product(String maker, String model, String type) {
        this.maker = maker;
        this.model = model;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
