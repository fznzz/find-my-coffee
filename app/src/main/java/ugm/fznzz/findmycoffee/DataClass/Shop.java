package ugm.fznzz.findmycoffee.DataClass;

public class Shop {
    private String shopName;
    private String address;
    private String openHours;
    private String link;
    private String priceRange;

    public Shop() {
    }

    public Shop(String shopName, String address, String openHours, String link, String priceRange) {
        this.shopName = shopName;
        this.address = address;
        this.openHours = openHours;
        this.link = link;
        this.priceRange = priceRange;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
