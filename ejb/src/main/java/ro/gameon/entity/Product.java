package ro.gameon.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bogdan on 2/2/14.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GEN")
    @SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
    private Long id;

    @Column(name = "PRODUCT_CODE", nullable = false)
    private String productCode;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PICTURE_LINK")
    private String pictureLink;

    @Column(name = "BANNER_LINK")
    private String bannerLink;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private Brand brand;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBannerLink() {
        return bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
