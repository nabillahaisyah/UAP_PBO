package uap;
import db.DBHelper;
import java.sql.Connection;
import uap.Penjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PenjualanModel {
     private final Connection CONN;
    
    public PenjualanModel(){
        this.CONN = DBHelper.getConnection();
    }
    public void addPenjualan(Penjualan  pjl){
        String insert = "INSERT INTO penjualan VALUES ('"
                + pjl.getId_transaksi()+ "', '" + pjl.getJumlahProduk()+ "', '" + pjl.getStok() + "', '" + pjl.getNama_produk()+"');";
        System.out.println(insert);
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Ditambahkan");
           }else{
               System.out.println("Data yang ditambahkan sudah ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Ditambahkan");
        }
    }
     
     public void deletePenjualan(Penjualan pjl){
        String delete = "DELETE FROM penjualan WHERE id_transaksi = '"+ pjl.getId_transaksi()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
//                  System.out.println(insert);
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
     public ObservableList<Penjualan> getPenjualan(){
        String query="SELECT * FROM penjualan";
        ObservableList<Penjualan> pjl=FXCollections.observableArrayList();
        try {
            ResultSet rs= CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Penjualan temp=new Penjualan(rs.getInt("id_transaksi"),rs.getInt("jumlahProduk"),rs.getInt("stok"),rs.getString("nama_produk"));
                pjl.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        }catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return pjl;
    }
}