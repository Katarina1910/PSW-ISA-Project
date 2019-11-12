package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "priceList")
    private Set<PriceListItem>  priceList;

    @OneToOne(mappedBy = "priceList")
    private Clinic clinic;


    public PriceList() {

    }

    public Set<PriceListItem> getPriceList() {
        return priceList;
    }

    public void setPriceList(Set<PriceListItem> priceList) {
        this.priceList = priceList;
    }
}
