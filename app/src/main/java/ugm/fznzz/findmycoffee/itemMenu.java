package ugm.fznzz.findmycoffee;

public class itemMenu {
    private String namaStore;
    private String alamat;

    public itemMenu() {
    }

    public itemMenu(String namaStore, String alamat) {
        this.namaStore = namaStore;
        this.alamat = alamat;
    }

    public String getNamaStore() {
        return namaStore;
    }

    public void setNamaStore(String namaStore) {
        this.namaStore = namaStore;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
