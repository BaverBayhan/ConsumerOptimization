package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "VacuumCleanerPost")
public class VacuumCleanerPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String vacuumCleanerUsagePerWeek;
    @Column
    private String squareMeterVacuumed;
    @Column
    private String vacuumCleanerBrand;
    @Column
    private String robotVacuumCleanerUsage;
    @Column
    private String brandOfRobotVacuumCleaner;

    public VacuumCleanerPost() {
    }

    public VacuumCleanerPost(String vacuumCleanerUsagePerWeek, String squareMeterVacuumed, String vacuumCleanerBrand, String robotVacuumCleanerUsage, String brandOfRobotVacuumCleaner) {
        this.vacuumCleanerUsagePerWeek = vacuumCleanerUsagePerWeek;
        this.squareMeterVacuumed = squareMeterVacuumed;
        this.vacuumCleanerBrand = vacuumCleanerBrand;
        this.robotVacuumCleanerUsage = robotVacuumCleanerUsage;
        this.brandOfRobotVacuumCleaner = brandOfRobotVacuumCleaner;
    }

    public Long getId() {
        return id;
    }

    public String getVacuumCleanerUsagePerWeek() {
        return vacuumCleanerUsagePerWeek;
    }

    public void setVacuumCleanerUsagePerWeek(String vacuumCleanerUsagePerWeek) {
        this.vacuumCleanerUsagePerWeek = vacuumCleanerUsagePerWeek;
    }

    public String getSquareMeterVacuumed() {
        return squareMeterVacuumed;
    }

    public void setSquareMeterVacuumed(String squareMeterVacuumed) {
        this.squareMeterVacuumed = squareMeterVacuumed;
    }

    public String getVacuumCleanerBrand() {
        return vacuumCleanerBrand;
    }

    public void setVacuumCleanerBrand(String vacuumCleanerBrand) {
        this.vacuumCleanerBrand = vacuumCleanerBrand;
    }

    public String getRobotVacuumCleanerUsage() {
        return robotVacuumCleanerUsage;
    }

    public void setRobotVacuumCleanerUsage(String robotVacuumCleanerUsage) {
        this.robotVacuumCleanerUsage = robotVacuumCleanerUsage;
    }

    public String getBrandOfRobotVacuumCleaner() {
        return brandOfRobotVacuumCleaner;
    }

    public void setBrandOfRobotVacuumCleaner(String brandOfRobotVacuumCleaner) {
        this.brandOfRobotVacuumCleaner = brandOfRobotVacuumCleaner;
    }
}
