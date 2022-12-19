package uap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HapusKategoriController implements Initializable{

    @FXML
    private TableView<Kategori> tableView;

    @FXML
    private TableColumn<Penjualan, String> colKategori;

    @FXML
    private TableColumn<Penjualan, Integer> colJumlah;

    @FXML
    private TableColumn<Penjualan, Integer> colStok;

    @FXML
    private TableColumn<Penjualan, String> colProduk;

    @FXML
    private TextField namaKategori;

    @FXML
    private TextField jumlah;

    @FXML
    private TextField stok;

    @FXML
    private TextField produk;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnHapus;

    @FXML
    void hapusData(ActionEvent event) throws IOException {
        Kategori ktg = new Kategori(namaKategori.getText());
        KategoriModel model=new KategoriModel();
        model.deleteKategori(ktg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HapusKategori.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void initialize(URL location, ResourceBundle resources) {
        KategoriModel model=new KategoriModel();
        colKategori.setCellValueFactory(new PropertyValueFactory<>("nama_kategori"));
        tableView.setItems(model.getKategori());
    }
}