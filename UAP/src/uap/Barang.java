package uap;

import java.util.ArrayList;

public class Barang extends Produk {

    private String barcode;
    private String expired;
    private ArrayList<Kategori> kategori = new ArrayList<>();
    private String kategori_;

    public Barang() {
    }

    public String getKategori_() {
        return kategori_;
    }

    public void setKategori_(String kategori_) {
        this.kategori_ = kategori_;
    }

    public Barang(String barcode, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
    }

    public Barang(String barcode, String expired, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
    }
    
    public Barang(String barcode, String nama_produk, double harga, int jumlah, double diskon, String kategori) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.kategori_ = kategori;
    }

    public Barang(String barcode) {
        this.barcode = barcode;
    }

    public Barang(String nama_produk, double harga, String barcode) {
        super(nama_produk, harga);
        this.barcode = barcode;
    }
    
    public Barang(String nama_produk, double harga, String barcode, String kategori) {
        super(nama_produk, harga);
        this.barcode = barcode;
        this.kategori_ = kategori;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }

    public boolean isExpired() {
        return true;
    }

    public void addKategori(Kategori k) {
        kategori.add(k);
    }
}
