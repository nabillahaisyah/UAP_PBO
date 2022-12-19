package uap;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class KasirController {

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnMakanan;

    @FXML
    private Button btnTransaksi;
    
    @FXML
    private Button btnKategori;

    @FXML
    void openBarang(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void openMakanan(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    void openTransaksi(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaksi.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnTransaksi.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void openKategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnTransaksi.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
