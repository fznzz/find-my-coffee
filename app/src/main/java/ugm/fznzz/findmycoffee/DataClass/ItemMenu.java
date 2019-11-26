package ugm.fznzz.findmycoffee.DataClass;

public class ItemMenu {
    private String shopName;
    private String address;

    public ItemMenu() {
    }

    public ItemMenu(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
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
}
