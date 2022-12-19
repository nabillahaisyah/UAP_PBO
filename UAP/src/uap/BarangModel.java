package uap;
import db.DBHelper;
import java.sql.Connection;
import uap.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BarangModel {
     private final Connection CONN;
    
    public BarangModel(){
        this.CONN = DBHelper.getConnection();
    }
    public void addBarang(Barang  brg){
        String insert = "INSERT INTO barang VALUES ('"
                + brg.getBarcode() + "', '" + brg.getNama_produk()+ "', '" + brg.getHarga() + "', '" + brg.getJumlah() + "', '" + brg.getDiskon() + "', '" + brg.getKategori_() + "');";
        System.out.println(insert);
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Ditambahkan");
           }else{
               System.out.println("Data Sudah Ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Ditambahkan");
        }
    }
     
     public void deleteProduk(Barang brg){
        String delete = "DELETE FROM barang WHERE barcode = '"+ brg.getBarcode()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
     public ObservableList<Barang> getBarang(){
        String query = "SELECT * FROM barang";
        ObservableList<Barang> brg=FXCollections.observableArrayList();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Barang barang = new Barang(rs.getString("nama_produk"),rs.getDouble("harga"), rs.getString("barcode"), rs.getString("kategori"));
                brg.add(barang);
            }
            System.out.println("Berhasil Mengambil Data");
        }catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return brg;
    }
}
