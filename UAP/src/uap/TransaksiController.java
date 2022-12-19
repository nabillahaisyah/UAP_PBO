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

public class TransaksiController implements Initializable{

    @FXML
    private TableView<Penjualan> tableView;

    @FXML
    private TableColumn<Penjualan, Integer> colId;

    @FXML
    private TableColumn<Penjualan, Integer> colJumlah;

    @FXML
    private TableColumn<Penjualan, Integer> colStok;

    @FXML
    private TableColumn<Penjualan, String> colProduk;

    @FXML
    private TextField id;

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
    void openHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HapusTransaksi.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kasir.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void tambahData(ActionEvent event) throws IOException {
        Penjualan pjl=new Penjualan(Integer.parseInt(id.getText()),Integer.parseInt(jumlah.getText()),Integer.parseInt(stok.getText()),produk.getText());
        PenjualanModel model=new PenjualanModel();
        model.addPenjualan(pjl);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaksi.fxml"));
        Parent root = loader.load();
        Stage stage= (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public void initialize(URL location, ResourceBundle resources) {
        PenjualanModel model=new PenjualanModel();
        colId.setCellValueFactory(new PropertyValueFactory<>("id_transaksi"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlahProduk"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        colProduk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        tableView.setItems(model.getPenjualan());
    }
}