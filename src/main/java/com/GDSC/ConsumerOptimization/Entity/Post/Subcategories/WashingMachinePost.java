package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;


@Entity
@Table(name = "WashingMachinePost")
public class WashingMachinePost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String byHandOrMachine;
    @Column
    private String avgLaundryPerWeek;
    @Column
    private String typeOfDetergent;
    @Column
    private String detergentConsumptionPerWash;
    @Column
    private String detergentBrand;
    @Column
    private String degreeOfWash;
    @Column
    private String fabricSoftenerUsage;
    @Column
    private String mlOfFabricSoftenerUsage;
    @Column
    private String fabricSoftenerBrand;
    @Column
    private String brandOfWashingMachine;
    @Column
    private String dryingMachineUsage;
    @Column
    private String dryingMachineUsagePerWeek;
    @Column
    private String brandOfDryingMachine;
    @Column
    private String solidityRatio;

    public WashingMachinePost() {
    }

    public WashingMachinePost(String byHandOrMachine, String avgLaundryPerWeek, String typeOfDetergent, String detergentConsumptionPerWash, String detergentBrand, String degreeOfWash, String fabricSoftenerUsage, String mlOfFabricSoftenerUsage, String fabricSoftenerBrand, String brandOfWashingMachine, String dryingMachineUsage, String dryingMachineUsagePerWeek, String brandOfDryingMachine, String solidityRatio) {
        this.byHandOrMachine = byHandOrMachine;
        this.avgLaundryPerWeek = avgLaundryPerWeek;
        this.typeOfDetergent = typeOfDetergent;
        this.detergentConsumptionPerWash = detergentConsumptionPerWash;
        this.detergentBrand = detergentBrand;
        this.degreeOfWash = degreeOfWash;
        this.fabricSoftenerUsage = fabricSoftenerUsage;
        this.mlOfFabricSoftenerUsage = mlOfFabricSoftenerUsage;
        this.fabricSoftenerBrand = fabricSoftenerBrand;
        this.brandOfWashingMachine = brandOfWashingMachine;
        this.dryingMachineUsage = dryingMachineUsage;
        this.dryingMachineUsagePerWeek = dryingMachineUsagePerWeek;
        this.brandOfDryingMachine = brandOfDryingMachine;
        this.solidityRatio = solidityRatio;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getByHandOrMachine() {
        return byHandOrMachine;
    }

    public void setByHandOrMachine(String byHandOrMachine) {
        this.byHandOrMachine = byHandOrMachine;
    }

    public String getAvgLaundryPerWeek() {
        return avgLaundryPerWeek;
    }

    public void setAvgLaundryPerWeek(String avgLaundryPerWeek) {
        this.avgLaundryPerWeek = avgLaundryPerWeek;
    }

    public String getTypeOfDetergent() {
        return typeOfDetergent;
    }

    public void setTypeOfDetergent(String typeOfDetergent) {
        this.typeOfDetergent = typeOfDetergent;
    }

    public String getDetergentConsumptionPerWash() {
        return detergentConsumptionPerWash;
    }

    public void setDetergentConsumptionPerWash(String detergentConsumptionPerWash) {
        this.detergentConsumptionPerWash = detergentConsumptionPerWash;
    }
    public String getDetergentBrand() {
        return detergentBrand;
    }

    public void setDetergentBrand(String detergentBrand) {
        this.detergentBrand = detergentBrand;
    }

    public String getDegreeOfWash() {
        return degreeOfWash;
    }

    public void setDegreeOfWash(String degreeOfWash) {
        this.degreeOfWash = degreeOfWash;
    }

    public String getFabricSoftenerUsage() {
        return fabricSoftenerUsage;
    }

    public void setFabricSoftenerUsage(String fabricSoftenerUsage) {
        this.fabricSoftenerUsage = fabricSoftenerUsage;
    }

    public String getMlOfFabricSoftenerUsage() {
        return mlOfFabricSoftenerUsage;
    }

    public void setMlOfFabricSoftenerUsage(String mlOfFabricSoftenerUsage) {
        this.mlOfFabricSoftenerUsage = mlOfFabricSoftenerUsage;
    }

    public String getFabricSoftenerBrand() {
        return fabricSoftenerBrand;
    }

    public void setFabricSoftenerBrand(String fabricSoftenerBrand) {
        this.fabricSoftenerBrand = fabricSoftenerBrand;
    }

    public String getBrandOfWashingMachine() {
        return brandOfWashingMachine;
    }

    public void setBrandOfWashingMachine(String brandOfWashingMachine) {
        this.brandOfWashingMachine = brandOfWashingMachine;
    }

    public String getDryingMachineUsage() {
        return dryingMachineUsage;
    }

    public void setDryingMachineUsage(String dryingMachineUsage) {
        this.dryingMachineUsage = dryingMachineUsage;
    }

    public String getdryingMachineUsagePerWeek() {
        return dryingMachineUsagePerWeek;
    }

    public void setdryingMachineUsagePerWeek(String dryingMachineUsagePerWeek) {
        this.dryingMachineUsagePerWeek = dryingMachineUsagePerWeek;
    }

    public String getBrandOfDryingMachine() {
        return brandOfDryingMachine;
    }

    public void setBrandOfDryingMachine(String brandOfDryingMachine) {
        this.brandOfDryingMachine = brandOfDryingMachine;
    }

    public String getDryingMachineUsagePerWeek() {
        return dryingMachineUsagePerWeek;
    }

    public void setDryingMachineUsagePerWeek(String dryingMachineUsagePerWeek) {
        this.dryingMachineUsagePerWeek = dryingMachineUsagePerWeek;
    }

    public String getSolidityRatio() {
        return solidityRatio;
    }

    public void setSolidityRatio(String solidityRatio) {
        this.solidityRatio = solidityRatio;
    }

    @Override
    public String toString() {
        return "WashingMachinePost{" +
                "id=" + id +
                ", byHandOrMachine='" + byHandOrMachine + '\'' +
                ", avgLaundryPerWeek='" + avgLaundryPerWeek + '\'' +
                ", typeOfDetergent='" + typeOfDetergent + '\'' +
                ", detergentConsumptionPerWash='" + detergentConsumptionPerWash + '\'' +
                ", detergentBrand='" + detergentBrand + '\'' +
                ", degreeOfWash='" + degreeOfWash + '\'' +
                ", fabricSoftenerUsage='" + fabricSoftenerUsage + '\'' +
                ", mlOfFabricSoftenerUsage='" + mlOfFabricSoftenerUsage + '\'' +
                ", fabricSoftenerBrand='" + fabricSoftenerBrand + '\'' +
                ", brandOfWashingMachine='" + brandOfWashingMachine + '\'' +
                ", dryingMachineUsage='" + dryingMachineUsage + '\'' +
                ", dryingMachineUsagePerWeek='" + dryingMachineUsagePerWeek + '\'' +
                ", brandOfDryingMachine='" + brandOfDryingMachine + '\'' +
                '}';
    }
}
