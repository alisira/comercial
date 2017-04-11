/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author asira
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "products", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p order by p.idProduct")
    , @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
    , @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description")
    , @NamedQuery(name = "Products.findByCode", query = "SELECT p FROM Products p WHERE p.code = :code")
    , @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")
    , @NamedQuery(name = "Products.findByStock", query = "SELECT p FROM Products p WHERE p.stock = :stock")
    , @NamedQuery(name = "Products.findByMeasure", query = "SELECT p FROM Products p WHERE p.measure = :measure")
    , @NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status")
    , @NamedQuery(name = "Products.findByCreatedAt", query = "SELECT p FROM Products p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Products.findByUpdatedAt", query = "SELECT p FROM Products p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Products.findByMaterial", query = "SELECT p FROM Products p WHERE p.material = :material")
    , @NamedQuery(name = "Products.findByFinish", query = "SELECT p FROM Products p WHERE p.finish = :finish")
    , @NamedQuery(name = "Products.findBySize", query = "SELECT p FROM Products p WHERE p.size = :size")
    , @NamedQuery(name = "Products.findByItemBox", query = "SELECT p FROM Products p WHERE p.itemBox = :itemBox")
    , @NamedQuery(name = "Products.findByKgMeter", query = "SELECT p FROM Products p WHERE p.kgMeter = :kgMeter")
    , @NamedQuery(name = "Products.findByPriceSample", query = "SELECT p FROM Products p WHERE p.priceSample = :priceSample")
    , @NamedQuery(name = "Products.findByPalette", query = "SELECT p FROM Products p WHERE p.palette = :palette")
    , @NamedQuery(name = "Products.findByRank", query = "SELECT p FROM Products p WHERE p.rank = :rank")
    , @NamedQuery(name = "Products.findByIdProduct", query = "SELECT p FROM Products p WHERE p.idProduct = :idProduct")})

@JsonInclude(Include.NON_NULL)
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "stock")
    private double stock;
    @Basic(optional = false)
    @Column(name = "measure")
    private double measure;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    
    @Column(name = "created_at")
    @JsonIgnore
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updated_at")    
    private Date updatedAt;    
    
    @Basic(optional = false)
    @Column(name = "material")
    private String material;
    @Basic(optional = false)
    @Column(name = "finish")
    private String finish;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "item_box")
    private int itemBox;
    @Basic(optional = false)
    @Column(name = "kg_meter")
    private double kgMeter;
    @Basic(optional = false)
    @Column(name = "price_sample")
    private double priceSample;
    @Column(name = "palette")
    private String palette;
    @Column(name = "rank")
    private String rank;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Long idProduct;    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idProduct")
    @Column(nullable=false)
    @JsonIgnore
    private Collection<OrderDetail> orderDetailCollection;
    
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnore
    private Category idCategory;
    
    @JoinColumn(name = "id_color", referencedColumnName = "id_color")
    @JsonProperty(access = Access.WRITE_ONLY)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idColor")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Color idColor;
    
    @JoinColumn(name = "id_enviroment", referencedColumnName = "id_enviroment")
    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Enviroment idEnviroment;
    
    @JoinColumn(name = "id_image", referencedColumnName = "id_image")
    @ManyToOne
    @JsonIgnore    
    private Image idImage;
    
    @JoinColumn(name = "id_purpose", referencedColumnName = "id_purpose")
    @ManyToOne(optional = false)
    @JsonProperty(access = Access.READ_ONLY)
    //@JsonIgnoreProperties(ignoreUnknown = true)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    //@JsonProperty(access = Access.READ_ONLY)
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idTaskAction")
    private Purpose idPurpose;

    public Products() {
    }

    public Products(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Products(Long idProduct, String name, String description, String code, double price, double stock, double measure, short status, String material, String finish, String size, int itemBox, double kgMeter, double priceSample) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.measure = measure;
        this.status = status;
        this.material = material;
        this.finish = finish;
        this.size = size;
        this.itemBox = itemBox;
        this.kgMeter = kgMeter;
        this.priceSample = priceSample;
    }
    
    public Products(Products pro) {
    	this.idProduct = pro.idProduct;
        this.name = pro.name;
        this.description = pro.description;
        this.code = pro.code;
        this.price = pro.price;
        this.stock = pro.stock;
        this.measure = pro.measure;
        this.status = pro.status;
        this.material = pro.material;
        this.finish = pro.finish;
        this.size = pro.size;
        this.itemBox = pro.itemBox;
        this.kgMeter = pro.kgMeter;
        this.priceSample = pro.priceSample;
        this.setIdColor(pro.getIdColor());
        this.setIdCategory(pro.getIdCategory());
        this.setIdEnviroment(pro.getIdEnviroment());
        this.setIdPurpose(pro.getIdPurpose());
        this.setIdImage(pro.getIdImage());
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreatedAt() {
		return createdAt;
	}

    public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getItemBox() {
        return itemBox;
    }

    public void setItemBox(int itemBox) {
        this.itemBox = itemBox;
    }

    public double getKgMeter() {
        return kgMeter;
    }

    public void setKgMeter(double kgMeter) {
        this.kgMeter = kgMeter;
    }

    public double getPriceSample() {
        return priceSample;
    }

    public void setPriceSample(double priceSample) {
        this.priceSample = priceSample;
    }

    public String getPalette() {
        return palette;
    }

    public void setPalette(String palette) {
        this.palette = palette;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Color getIdColor() {
        return idColor;
    }

    public void setIdColor(Color idColor) {
        this.idColor = idColor;
    }

    public Enviroment getIdEnviroment() {
        return idEnviroment;
    }

    public void setIdEnviroment(Enviroment idEnviroment) {
        this.idEnviroment = idEnviroment;
    }

    public Image getIdImage() {
        return idImage;
    }

    public void setIdImage(Image idImage) {
        this.idImage = idImage;
    }

    public Purpose getIdPurpose() {
        return idPurpose;
    }

    public void setIdPurpose(Purpose idPurpose) {
        this.idPurpose = idPurpose;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Products[ idProduct=" + idProduct + " ]";
    }
    
}
