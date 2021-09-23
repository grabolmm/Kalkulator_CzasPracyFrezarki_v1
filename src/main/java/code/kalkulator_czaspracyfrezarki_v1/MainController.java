package code.kalkulator_czaspracyfrezarki_v1;

import code.kalkulator_czaspracyfrezarki_v1.KlasyDoList.Material;
import code.kalkulator_czaspracyfrezarki_v1.KlasyDoList.OperacjaDoTabeli;
import code.kalkulator_czaspracyfrezarki_v1.Narzedzia.*;
import code.kalkulator_czaspracyfrezarki_v1.Olbiczenia.ObliczeniaCzasu;
import code.kalkulator_czaspracyfrezarki_v1.Olbiczenia.Parametry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class MainController {
    Narzedzie wybraneNarzedzie = new WybraneNarzedzie();
    Parametry parametry = new Parametry();
    ObliczeniaCzasu obliczeniaCzasu = new ObliczeniaCzasu();
    int material;
    double obliczoneObrotyWrzeciona = 0;
    double obliczonyPosuwNarzedzia = 0;
    int dlugoscObrysu;
    int glebokoscObrysu;
    ObservableList<Material> listaMaterialow = FXCollections.observableArrayList();
    ObservableList<Narzedzie> listaNarzedzi = FXCollections.observableArrayList();

//    ObservableList<Operacja> listaOperacji = FXCollections.observableArrayList(
//            new Operacja(1, wybraneNarzedzie.wyswietlNazwe(), "opis"),
//            new Operacja(2, "glowica", "opis 2")
//    );

    int i = 1;

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private Button akceptuj1;
    @FXML
    private void wyborMaterialu(){
        label1.setText("wybrano: " + choiceBox1.getValue());
        if (choiceBox1.getValue() == "Stal"){
            material = 1;
        } else if (choiceBox1.getValue() == "Aluminium"){
            material = 2;
        }else if (choiceBox1.getValue() == "Żeliwo"){
            material = 3;
        }
    }
    @FXML
    private Label label1;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private Button akceptuj2;
    @FXML
    private void wyborNarzedzia(){
        if (choiceBox2.getValue() == "Glowica fi 25 HCF"){
            wybraneNarzedzie = new Glowica25Hcf();
            if (material == 1){
                wybraneNarzedzie.parametryDlaStali();
            }else if (material == 2){
                wybraneNarzedzie.parametryDlaAluminium();
            }else if (material == 3){
                wybraneNarzedzie.parametryDlaZeliwa();
            }
        } else if (choiceBox2.getValue() == "Glowica fi 40 SDKT"){
            wybraneNarzedzie = new Glowica40Sdkt();
            if (material == 1){
                wybraneNarzedzie.parametryDlaStali();
            }else if (material == 2){
                wybraneNarzedzie.parametryDlaAluminium();
            }else if (material == 3){
                wybraneNarzedzie.parametryDlaZeliwa();
            }
        }else if (choiceBox2.getValue() == "Frez 16 VHM"){
            wybraneNarzedzie = new Frez16Vhm();
            if (material == 1){
                wybraneNarzedzie.parametryDlaStali();
            }else if (material == 2){
                wybraneNarzedzie.parametryDlaAluminium();
            }else if (material == 3){
                wybraneNarzedzie.parametryDlaZeliwa();
            }
        }
        obliczeniaObrotów();
        obliczeniaPosuw();
        listaParametrow.setText(parametry.wyswietlParametry(wybraneNarzedzie.vc(), wybraneNarzedzie.d(),
                obliczoneObrotyWrzeciona, obliczonyPosuwNarzedzia, wybraneNarzedzie.ap(), wybraneNarzedzie.fz(), wybraneNarzedzie.z()));
    }
    @FXML
    private Label listaParametrow;
    @FXML
    private TextField textField1;
    @FXML
    private void wprowadzDlugoscObrysu(){
        dlugoscObrysu = Integer.parseInt(textField1.getText());
        wprowadzonaDlugoscObrysu.setText(textField1.getText() + " mm");
    }
    @FXML
    private Label wprowadzonaDlugoscObrysu;
    @FXML
    private TextField textField2;
    @FXML
    private void wprowadzGlebokoscObrysu(){
        glebokoscObrysu = Integer.parseInt(textField2.getText());
        wprowadzonaGlebokoscObrysu.setText(textField2.getText() + " mm");
    }
    @FXML
    private Label wprowadzonaGlebokoscObrysu;
    @FXML
    private Button obliczCzas;
    @FXML
    private void obliczenieCzasu(){
        double wynik1 = obliczeniaCzasu.czas(dlugoscObrysu,glebokoscObrysu, wybraneNarzedzie.ap(), obliczonyPosuwNarzedzia);
        wynik.setText(String.valueOf((int)wynik1) + " min");
    }
    @FXML
    private Button dodajDoTabeli;
    @FXML
    private void dodanieDoTabeli(){


//        OperacjaDoTabeli operacjaDoTabeli = new OperacjaDoTabeli(i, choiceBox2.getValue(), "opis");
//        ObservableList<OperacjaDoTabeli> listaOperacji = tableView.getItems();
//        listaOperacji.add(operacjaDoTabeli);
//        tableView.setItems(listaOperacji);
//        i += 1;
//
//        choiceBox2.setValue("");
//        textField1.setText("");
//        textField2.setText("");
//        listaParametrow.setText("");
//        glebokoscObrysu = 0;
//        dlugoscObrysu = 0;
//        obliczoneObrotyWrzeciona = 0;
//        obliczonyPosuwNarzedzia = 0;
//        wprowadzonaDlugoscObrysu.setText("");
//        wprowadzonaGlebokoscObrysu.setText("");
//        wynik.setText("");



    }
    @FXML
    private Label wynik;
    @FXML
    private Button eksportuj;
    @FXML
    private void eksportowaniePliku(){

    }
    @FXML
    private TableView<OperacjaDoTabeli> tableView;
    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolLp;
    @FXML
    private TableColumn<OperacjaDoTabeli, String> kolNarzedzie;
    @FXML
    private TableColumn<OperacjaDoTabeli, String> kolOpisOperacji;
    @FXML
    private ImageView imageView;



    @FXML
    public void initialize(){
        zaladujListeMaterialow();
        zaladujListeNarzedzi();

        kolLp.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("lp"));
        kolNarzedzie.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, String>("nazwa"));
        kolOpisOperacji.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, String>("opisOperacji"));
//        tableView.setItems(listaOperacji);
//        tableView.getColumns().addAll(kolLp, kolNarzedzie, kolOpisOperacji);

    }
    private void zaladujListeMaterialow(){
        listaMaterialow.removeAll(listaMaterialow);
        Material stal = new Material("Stal");
        Material aluminium = new Material("Aluminium");
        Material zeliwo = new Material("Żeliwo");

//        listaMaterialow.addAll(stal.nazwa, aluminium.nazwa, zeliwo.nazwa);
        choiceBox1.getItems().addAll(stal.nazwa, aluminium.nazwa, zeliwo.nazwa);
//        choiceBox1.getItems().add(stal.nazwa);
//        choiceBox1.getItems().add(aluminium.nazwa);
//        choiceBox1.getItems().add(zeliwo.nazwa);
    }
    private void zaladujListeNarzedzi(){
        listaNarzedzi.removeAll(listaNarzedzi);
        Narzedzie glowica25Hcf = new Glowica25Hcf();
        Narzedzie glowica40Sdkt = new Glowica40Sdkt();
        Narzedzie frez16Vhm = new Frez16Vhm();

        choiceBox2.getItems().addAll(glowica25Hcf.wyswietlNazwe(), glowica40Sdkt.wyswietlNazwe(), frez16Vhm.wyswietlNazwe());
    }
    public double obliczeniaObrotów(){
        return obliczoneObrotyWrzeciona = parametry.obliczObroty(wybraneNarzedzie.vc(), wybraneNarzedzie.d());
    }
    public double obliczeniaPosuw(){
        return obliczonyPosuwNarzedzia = parametry.obliczPosuw(wybraneNarzedzie.z(), wybraneNarzedzie.fz(), obliczoneObrotyWrzeciona);
    }

}