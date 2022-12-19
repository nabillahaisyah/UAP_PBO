/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Penjualan implements ProductCounter{
    private ArrayList<Produk> listProduk=new ArrayList<>();
    private int id_transaksi;
    private int jumlahProduk;
    private int stok;
    private String nama_produk;

    
    
    public Penjualan(){
    }

    public Penjualan(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Penjualan(int id_transaksi, int jumlahProduk, int stok) {
        this.id_transaksi = id_transaksi;
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }
    public Penjualan(int id_transaksi, int jumlahProduk, int stok, String produk) {
        this.id_transaksi = id_transaksi;
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
        this.nama_produk=produk;
    }
    public Penjualan(int jumlahProduk, int stok) {
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }
    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    
    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
    public void getProduk(){
        
    }
    @Override
    public void hitungJumlahProduk(){
        
    }
    @Override
    public void hitungHargaProduk(){
        
    }
}
