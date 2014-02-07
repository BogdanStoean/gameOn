package ro.gameon.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bogdan on 2/2/14.
 */
@Entity
@Table(name = "BRANDS")
public class Brand implements Serializable{


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_SEQ_GEN")
    @SequenceGenerator(name = "BRAND_SEQ_GEN", sequenceName = "SEQ_BRAND", allocationSize = 1)
    private Long id;

    @Column(name = "BRAND_CODE", nullable = false)
    private String brandCode;

    @Column(name = "BRAND_NAME", nullable = false)
    private String brandName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
