package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;


import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name = "energyConsumptionPost")
public class EnergyConsumptionPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String electricityUsageAmount;
    @Column
    private String naturalGasUsageAmount;
    @Column
    private String waterUsageAmount;
    @Column
    private String publicTransportOrOwnVehicle;
    @Column
    private String kilometersDrivePerMonth;
    @Column
    private String typeOfFuel;
    @Column
    private String publicTransport;
    @Column
    private String publicTransportUsageFrequency;

    public EnergyConsumptionPost() {
    }

    public EnergyConsumptionPost(String electricityUsageAmount, String naturalGasUsageAmount, String waterUsageAmount, String publicTransportOrOwnVehicle, String kilometersDrivePerMonth, String typeOfFuel, String publicTransport, String publicTransportUsageFrequency) {
        this.electricityUsageAmount = electricityUsageAmount;
        this.naturalGasUsageAmount = naturalGasUsageAmount;
        this.waterUsageAmount = waterUsageAmount;
        this.publicTransportOrOwnVehicle = publicTransportOrOwnVehicle;
        this.kilometersDrivePerMonth = kilometersDrivePerMonth;
        this.typeOfFuel = typeOfFuel;
        this.publicTransport = publicTransport;
        this.publicTransportUsageFrequency = publicTransportUsageFrequency;
    }

    @Override
    public Long getId() {
        return id;
    }


    public String getElectricityUsageAmount() {
        return electricityUsageAmount;
    }

    public void setElectricityUsageAmount(String electricityUsageAmount) {
        this.electricityUsageAmount = electricityUsageAmount;
    }

    public String getNaturalGasUsageAmount() {
        return naturalGasUsageAmount;
    }

    public void setNaturalGasUsageAmount(String naturalGasUsageAmount) {
        this.naturalGasUsageAmount = naturalGasUsageAmount;
    }

    public String getWaterUsageAmount() {
        return waterUsageAmount;
    }

    public void setWaterUsageAmount(String waterUsageAmount) {
        this.waterUsageAmount = waterUsageAmount;
    }

    public String getPublicTransportOrOwnVehicle() {
        return publicTransportOrOwnVehicle;
    }

    public void setPublicTransportOrOwnVehicle(String publicTransportOrOwnVehicle) {
        this.publicTransportOrOwnVehicle = publicTransportOrOwnVehicle;
    }

    public String getKilometersDrivePerMonth() {
        return kilometersDrivePerMonth;
    }

    public void setKilometersDrivePerMonth(String kilometersDrivePerMonth) {
        this.kilometersDrivePerMonth = kilometersDrivePerMonth;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(String publicTransport) {
        this.publicTransport = publicTransport;
    }

    public String getPublicTransportUsageFrequency() {
        return publicTransportUsageFrequency;
    }

    public void setPublicTransportUsageFrequency(String publicTransportUsageFrequency) {
        this.publicTransportUsageFrequency = publicTransportUsageFrequency;
    }

    @Override
    public String toString() {
        return "EnergyConsumptionPost{" +
                "id=" + id +
                ", electricityUsageAmount='" + electricityUsageAmount + '\'' +
                ", naturalGasUsageAmount='" + naturalGasUsageAmount + '\'' +
                ", waterUsageAmount='" + waterUsageAmount + '\'' +
                ", publicTransportOrOwnVehicle='" + publicTransportOrOwnVehicle + '\'' +
                ", kilometersDrivePerMonth='" + kilometersDrivePerMonth + '\'' +
                ", typeOfFuel='" + typeOfFuel + '\'' +
                ", publicTransport='" + publicTransport + '\'' +
                ", publicTransportUsageFrequency='" + publicTransportUsageFrequency + '\'' +
                '}';
    }
}
