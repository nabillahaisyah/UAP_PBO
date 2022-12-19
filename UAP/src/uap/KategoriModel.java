package uap;
import db.DBHelper;
import java.sql.Connection;
import uap.Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KategoriModel {
     private final Connection CONN;
    
    public KategoriModel(){
        this.CONN = DBHelper.getConnection();
    }
    public void addKategori(Kategori  ktg){
        String insert = "INSERT INTO kategori VALUES ('"
                + ktg.getNama_kategori() + "');";
        System.out.println(insert);
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Ditambahkan");
           }else{
               System.out.println("Data Sudah Ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Ditambahkan");
        }
    }
     
     public void deleteKategori(Kategori ktg){
        String delete = "DELETE FROM kategori WHERE nama_kategori = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
     public ObservableList<Kategori> getKategori(){
        String query = "SELECT * FROM kategori";
        ObservableList<Kategori> ktg = FXCollections.observableArrayList();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Kategori kategori = new Kategori(rs.getString("nama_kategori"));
                ktg.add(kategori);
            }
            System.out.println("Berhasil Mengambil Data");
        }catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return ktg;
    }
}
