package code.kalkulator_czaspracyfrezarki_v1;

import code.kalkulator_czaspracyfrezarki_v1.KlasyDoList.DaneWejscioweDoTabeli;
import code.kalkulator_czaspracyfrezarki_v1.KlasyDoList.Material;
import code.kalkulator_czaspracyfrezarki_v1.KlasyDoList.OperacjaDoTabeli;
import code.kalkulator_czaspracyfrezarki_v1.Narzedzia.*;
import code.kalkulator_czaspracyfrezarki_v1.Olbiczenia.ObliczeniaCzasu;
import code.kalkulator_czaspracyfrezarki_v1.Olbiczenia.Parametry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class SzablonController {
    Narzedzie wybraneNarzedzie = new WybraneNarzedzie();
    Parametry parametry = new Parametry();
    ObliczeniaCzasu obliczeniaCzasu = new ObliczeniaCzasu();
    Date dataDzisiejsza = new Date();
    int material;
    double obliczoneObrotyWrzeciona = 0;
    double obliczonyPosuwNarzedzia = 0;
    int dlugoscObrysu;
    int glebokoscObrysu;
    int i; //ilość operacji licznik
    int k; // ilość operacji wybrana
    double wynikCzas; // zmienna do wyniku czasu

    ObservableList<Material> listaMaterialow = FXCollections.observableArrayList();
    ObservableList<Narzedzie> listaNarzedzi = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox choiceBoxWyborMaterialu;

    private void zaladujListeMaterialow() {
        listaMaterialow.removeAll(listaMaterialow);
        Material stal = new Material("Stal");
        Material aluminium = new Material("Aluminium");
        Material zeliwo = new Material("Żeliwo");

        choiceBoxWyborMaterialu.getItems().addAll(stal.nazwa, aluminium.nazwa, zeliwo.nazwa);
    }

    @FXML
    private TextField textFieldIloscOperacji;

    @FXML
    private TextField textFieldNazwa;

    @FXML
    private TextField textFieldNrRysunku;

    @FXML
    private Button butonWprowadzDane;

    @FXML
    void wprowadzDane(ActionEvent event) {
        ObservableList<DaneWejscioweDoTabeli> daneWejscioweDoTabeliObservableList = tableViewDaneWejsciowe.getItems();
        // czyszczenie tablicy
        daneWejscioweDoTabeliObservableList.clear();
        tableViewDaneWejsciowe.setItems(daneWejscioweDoTabeliObservableList);
        // dodanie danych poczatkowych do tablicy
        DaneWejscioweDoTabeli daneWejscioweDoTabeli = new DaneWejscioweDoTabeli(textFieldNazwa.getText(),
                textFieldNrRysunku.getText(), (String) choiceBoxWyborMaterialu.getValue(), dataDzisiejsza);
        daneWejscioweDoTabeliObservableList.add(daneWejscioweDoTabeli);
        tableViewDaneWejsciowe.setItems(daneWejscioweDoTabeliObservableList);
        // wyświetlenie ilości operacji
        labelIloscOperacji.setText("OBLICZENIA");
        i = 1;
        k = Integer.parseInt(textFieldIloscOperacji.getText());
        labelIloscOperacji.setText(labelIloscOperacji.getText() + " - OPERACJA " + String.valueOf(i) + " z " + textFieldIloscOperacji.getText());
        // wybor materialu
        metodaWyborMaterialu();
    }
    @FXML
    private Label labelIloscOperacji;

    @FXML
    private ChoiceBox choiceBoxWyborNarzedzia;

    private void zaladujListeNarzedzi(){
        listaNarzedzi.removeAll(listaNarzedzi);
        Narzedzie glowica25Hcf = new Glowica25Hcf();
        Narzedzie glowica40Sdkt = new Glowica40Sdkt();
        Narzedzie frez16Vhm = new Frez16Vhm();
        choiceBoxWyborNarzedzia.getItems().addAll(glowica25Hcf.wyswietlNazwe(), glowica40Sdkt.wyswietlNazwe(), frez16Vhm.wyswietlNazwe());
    }

    @FXML
    private Button buttonPokazParametrySkrawania;

    @FXML
    private void pokazParametrySkrawania(){
        metodaWyborMaterialu();
        metodaWyborNarzedzia();
    }
    @FXML
    private Label labelParametrySkrawania;

    @FXML
    private TextField textFieldDlugoscObrysu;

    @FXML
    private TextField textFieldGlebokoscObrysu;

    @FXML
    private TextField textFieldOpisOperacji;

    @FXML
    private Button buttonObliczCzasObrobki;

    @FXML
    private Label labelWynik;

    @FXML
    void obliczenieCzasuObrobki(ActionEvent event) {
        metodaWyborMaterialu();
        metodaWyborNarzedzia();
        labelWynik.setText("wynik:");
        wynikCzas = obliczeniaCzasu.czas(Integer.parseInt(textFieldDlugoscObrysu.getText()),
                Integer.parseInt(textFieldGlebokoscObrysu.getText()),
                wybraneNarzedzie.ap(),
                obliczonyPosuwNarzedzia);
        labelWynik.setText(labelWynik.getText() + " " + String.valueOf((int)wynikCzas) + " min");
    }

    @FXML
    private TableView<OperacjaDoTabeli> tableViewTabela;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaOperacja;

    @FXML
    private TableColumn<OperacjaDoTabeli, String> kolumnaOpisOperacji;

    @FXML
    private TableColumn<OperacjaDoTabeli, String> kolumnaNarzedzie;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaVc;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaD;

    @FXML
    private TableColumn<OperacjaDoTabeli, Double> kolumnaFz;

    @FXML
    private TableColumn<OperacjaDoTabeli, Double> kolumnaAp;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaN;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaF;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaDlugoscObrysu;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaGlebokoscObrysu;

    @FXML
    private TableColumn<OperacjaDoTabeli, Integer> kolumnaCzasObrobki;

    @FXML
    private Button buttonDodajOperacjeDoTabeli;

    @FXML
    private TableView<DaneWejscioweDoTabeli> tableViewDaneWejsciowe;

    @FXML
    private TableColumn<DaneWejscioweDoTabeli, String> kolumnaNazwa;

    @FXML
    private TableColumn<DaneWejscioweDoTabeli, String> kolumnaNumerRysunku;

    @FXML
    private TableColumn<DaneWejscioweDoTabeli, String> kolumnaMaterial;

    @FXML
    private TableColumn<DaneWejscioweDoTabeli, Date> kolumnaData;

    @FXML
    void dodajOperacjeDoTabeli(ActionEvent event) {
        ObservableList<OperacjaDoTabeli> operacjaDoTabeliObservableList = tableViewTabela.getItems();
        // dodanie danych poczatkowych do tablicy
        OperacjaDoTabeli operacjaDoTabeli = new OperacjaDoTabeli(i, textFieldOpisOperacji.getText(),
                (String)choiceBoxWyborNarzedzia.getValue(), wybraneNarzedzie.vc(), wybraneNarzedzie.d(), wybraneNarzedzie.fz(),
                wybraneNarzedzie.ap(), (int)obliczoneObrotyWrzeciona, (int)obliczonyPosuwNarzedzia ,
                Integer.parseInt(textFieldDlugoscObrysu.getText()),
                Integer.parseInt(textFieldGlebokoscObrysu.getText()), (int)wynikCzas);
        operacjaDoTabeliObservableList.add(operacjaDoTabeli);
        tableViewTabela.setItems(operacjaDoTabeliObservableList);
    }

    @FXML
    public void initialize(){
        zaladujListeMaterialow();
        zaladujListeNarzedzi();

        //Załadowanie kolumn tabeli danych wejściowych
        kolumnaNazwa.setCellValueFactory(new PropertyValueFactory<DaneWejscioweDoTabeli, String>("nazwa"));
        kolumnaNumerRysunku.setCellValueFactory(new PropertyValueFactory<DaneWejscioweDoTabeli, String>("numerRysunku"));
        kolumnaMaterial.setCellValueFactory(new PropertyValueFactory<DaneWejscioweDoTabeli, String>("material"));
        kolumnaData.setCellValueFactory(new PropertyValueFactory<DaneWejscioweDoTabeli, Date>("dataDzisiejsza"));
        //Załadowanie kolumn tabeli operacji
        kolumnaOperacja.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("operacja"));
        kolumnaOpisOperacji.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, String>("opisOperacji"));
        kolumnaNarzedzie.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, String>("narzedzie"));
        kolumnaVc.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("vc"));
        kolumnaD.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("d"));
        kolumnaFz.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Double>("fz"));
        kolumnaAp.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Double>("ap"));
        kolumnaN.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("n"));
        kolumnaF.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("f"));
        kolumnaDlugoscObrysu.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("dlugoscObrysu"));
        kolumnaGlebokoscObrysu.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("glebokoscObrysu"));
        kolumnaCzasObrobki.setCellValueFactory(new PropertyValueFactory<OperacjaDoTabeli, Integer>("czasObrobki"));

    }
    public double obliczeniaObrotów(){
        return obliczoneObrotyWrzeciona = parametry.obliczObroty(wybraneNarzedzie.vc(), wybraneNarzedzie.d());
    }
    public double obliczeniaPosuw(){
        return obliczonyPosuwNarzedzia = parametry.obliczPosuw(wybraneNarzedzie.z(), wybraneNarzedzie.fz(), obliczoneObrotyWrzeciona);
    }
    public void metodaWyborMaterialu(){
        if (choiceBoxWyborMaterialu.getValue() == "Stal"){
            material = 1;
        } else if (choiceBoxWyborMaterialu.getValue() == "Aluminium"){
            material = 2;
        }else if (choiceBoxWyborMaterialu.getValue() == "Żeliwo"){
            material = 3;
        }
    }
    public void metodaWyborNarzedzia(){
        if (choiceBoxWyborNarzedzia.getValue() == "Glowica fi 25 HCF"){
            wybraneNarzedzie = new Glowica25Hcf();
            if (material == 1){
                wybraneNarzedzie.parametryDlaStali();
            }else if (material == 2){
                wybraneNarzedzie.parametryDlaAluminium();
            }else if (material == 3){
                wybraneNarzedzie.parametryDlaZeliwa();
            }
        } else if (choiceBoxWyborNarzedzia.getValue() == "Glowica fi 40 SDKT") {
            wybraneNarzedzie = new Glowica40Sdkt();
            if (material == 1){
                wybraneNarzedzie.parametryDlaStali();
            }else if (material == 2){
                wybraneNarzedzie.parametryDlaAluminium();
            }else if (material == 3){
                wybraneNarzedzie.parametryDlaZeliwa();
            }
        } else if (choiceBoxWyborNarzedzia.getValue() == "Frez 16 VHM") {
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
        labelParametrySkrawania.setText(parametry.wyswietlParametry(wybraneNarzedzie.vc(), wybraneNarzedzie.d(),
                obliczoneObrotyWrzeciona, obliczonyPosuwNarzedzia, wybraneNarzedzie.ap(), wybraneNarzedzie.fz(),
                wybraneNarzedzie.z()));
    }

}
