package ugm.fznzz.findmycoffee;

public class Shop {
    private String ShopName;
    private String Address;
    private String OpenHours;
    private String Link;
    private String PriceRange;

    public Shop() {
    }

    public Shop(String shopName, String address, String openHours, String link, String priceRange) {
        ShopName = shopName;
        Address = address;
        OpenHours = openHours;
        Link = link;
        PriceRange = priceRange;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOpenHours() {
        return OpenHours;
    }

    public void setOpenHours(String openHours) {
        OpenHours = openHours;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getPriceRange() {
        return PriceRange;
    }

    public void setPriceRange(String priceRange) {
        PriceRange = priceRange;
    }
}
