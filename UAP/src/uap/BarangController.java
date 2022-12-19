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

public class BarangController implements Initializable {

    @FXML
    private TextField namaBarang;

    @FXML
    private TextField hargaBarang;

    @FXML
    private TextField jumlahBarang;

    @FXML
    private TextField diskonBarang;

    @FXML
    private TextField barcodeBarang;

    @FXML
    private TextField kategoriBarang;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Barang> tableView;

    @FXML
    private TableColumn<Barang, String> colNama;

    @FXML
    private TableColumn<Barang, Double> colHarga;

    @FXML
    private TableColumn<Barang, String> colBarcode;
    
    @FXML
    private TableColumn<Barang, String> colKategori;

    @FXML
    void openHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HapusBarang.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kasir.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void tambahData(ActionEvent event) throws IOException {
        Barang brg = new Barang(barcodeBarang.getText(), namaBarang.getText(), Double.parseDouble(hargaBarang.getText()), Integer.parseInt(jumlahBarang.getText()), Double.parseDouble(diskonBarang.getText()), kategoriBarang.getText());
        BarangModel model = new BarangModel();
        model.addBarang(brg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BarangModel model = new BarangModel();
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        tableView.setItems(model.getBarang());
    }

}
