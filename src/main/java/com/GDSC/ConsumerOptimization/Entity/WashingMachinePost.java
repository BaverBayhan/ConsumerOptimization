package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="washing_machine_posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WashingMachinePost extends Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "piece_number")
    int piece_number;
    @Column(name = "degree")
    int degree;
    @Column(name = "weekly_frequency")
    int weekly_frequency;
    @Column(name = "detergent_type")
    String detergent_type;
    @Column(name = "avg_detergent_ml")
    String avg_detergent_ml;
    @Column(name = "detergent_brand")
    String detergent_brand;
    @Column(name = "fabric_softener_usage")
    String fabric_softener_usage;
    @Column(name = "fabric_softener_ml")
    String fabric_softener_ml;
    @Column(name = "washing_machine_brand")
    String washing_machine_brand;

    public Long getId() {
        return id;
    }

    public int getPiece_number() {
        return piece_number;
    }

    public void setPiece_number(int piece_number) {
        this.piece_number = piece_number;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getWeekly_frequency() {
        return weekly_frequency;
    }

    public void setWeekly_frequency(int weekly_frequency) {
        this.weekly_frequency = weekly_frequency;
    }

    public String getDetergent_type() {
        return detergent_type;
    }

    public void setDetergent_type(String detergent_type) {
        this.detergent_type = detergent_type;
    }

    public String getAvg_detergent_ml() {
        return avg_detergent_ml;
    }

    public void setAvg_detergent_ml(String avg_detergent_ml) {
        this.avg_detergent_ml = avg_detergent_ml;
    }

    public String getDetergent_brand() {
        return detergent_brand;
    }

    public void setDetergent_brand(String detergent_brand) {
        this.detergent_brand = detergent_brand;
    }

    public String getFabric_softener_usage() {
        return fabric_softener_usage;
    }

    public void setFabric_softener_usage(String fabric_softener_usage) {
        this.fabric_softener_usage = fabric_softener_usage;
    }

    public String getFabric_softener_ml() {
        return fabric_softener_ml;
    }

    public void setFabric_softener_ml(String fabric_softener_ml) {
        this.fabric_softener_ml = fabric_softener_ml;
    }

    public String getWashing_machine_brand() {
        return washing_machine_brand;
    }

    public void setWashing_machine_brand(String washing_machine_brand) {
        this.washing_machine_brand = washing_machine_brand;
    }

    @Override
    public String toString() {
        return "WashingMachinePost{" +
                "id=" + id +
                ", piece_number=" + piece_number +
                ", degree=" + degree +
                ", weekly_frequency=" + weekly_frequency +
                ", detergent_type='" + detergent_type + '\'' +
                ", avg_detergent_ml='" + avg_detergent_ml + '\'' +
                ", detergent_brand='" + detergent_brand + '\'' +
                ", fabric_softener_usage='" + fabric_softener_usage + '\'' +
                ", fabric_softener_ml='" + fabric_softener_ml + '\'' +
                ", washing_machine_brand='" + washing_machine_brand + '\'' +
                '}';
    }
}
