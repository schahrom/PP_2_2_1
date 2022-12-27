package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id", nullable = false)
    private Long carId;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return carId;
    }

    public void setId(Long id) {
        this.carId = id;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{ " +
                "id=" + carId +
                ", model='" + model + '\'' +
                ", series= " + series +
                " }";
    }
}
