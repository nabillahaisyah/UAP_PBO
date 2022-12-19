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

public class HapusMakananController implements Initializable {

    @FXML
    private TextField namaMakanan;

    @FXML
    private TextField hargaMakanan;

    @FXML
    private TextField jumlahMakanan;

    @FXML
    private TextField diskonMakanan;

    @FXML
    private TextField idMakanan;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnBack;

    @FXML
    private TextField dayaTahan;

    @FXML
    private TableView<Makanan> tableView;

    @FXML
    private TableColumn<Makanan, String> colNama;

    @FXML
    private TableColumn<Makanan, Double> colHarga;

    @FXML
    private TableColumn<Makanan, Integer> colId;

    @FXML
    void hapusData(ActionEvent event) throws IOException {
        Makanan mkn = new Makanan(Integer.parseInt(idMakanan.getText()));
        MakananModel model = new MakananModel();
        model.deleteMakanan(mkn);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HapusMakanan.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MakananModel model = new MakananModel();
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.setItems(model.getMakanan());
    }

}
