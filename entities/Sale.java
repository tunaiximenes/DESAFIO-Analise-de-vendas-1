package entities;

public class Sale {

    private Integer moth;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale(Integer moth, Integer year, String seller, Integer items, Double total) {
        this.moth = moth;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMoth() {
        return moth;
    }

    public void setMoth(Integer moth) {
        this.moth = moth;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public Double averagePrice(Double price, Integer item) {
        return price / items;
    }

    @Override
    public String toString() {
        return moth + "/" + year + ", " + seller + ", " + items + ", " + String.format("%.2f",total) + ", " + "pm = " + String.format("%.2f",averagePrice(total, items));
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
