package io.pivotal.bds.gemfire.data.ecom;

import java.util.List;

public class CatalogItem {

    private CatalogItemKey key;
    private String name;
    private String description;
    private List<Price> prices;
    private Dimensions dimensions;
    private Weight weight;

    public CatalogItem() {
    }

    public CatalogItem(CatalogItemKey key, String name, String description, List<Price> prices, Dimensions dimensions,
            Weight weight) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.prices = prices;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public CatalogItemKey getKey() {
        return key;
    }

    public void setKey(CatalogItemKey key) {
        this.key = key;
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

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CatalogItem [key=" + key + ", name=" + name + ", description=" + description + ", prices=" + prices
                + ", dimensions=" + dimensions + ", weight=" + weight + "]";
    }

}
