package application;
import java.io.IOException;
import java.time.LocalDate;

import gui.PessoaController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Pessoa;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane principal;
	
	
	private ObservableList<Pessoa> dados = FXCollections.observableArrayList();
	
	public Main() {
		dados.add(new Pessoa("João","Masiero",LocalDate.of(1983, 10, 29)));
		dados.add(new Pessoa("Maria","Joaquina",LocalDate.of(1798, 7, 13)));
		dados.add(new Pessoa("Pedro","Álvarez",LocalDate.of(1677, 4, 7)));
		dados.add(new Pessoa("Dolores","West",LocalDate.of(1866, 2, 20)));
		dados.add(new Pessoa("Ernesto","Silveira",LocalDate.of(1990, 12, 1)));
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Agenda");
		
		initMainStage();
		carregarTela();
		
	}
	
	private void carregarTela() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gui/principal.fxml"));
			AnchorPane pessoaView = (AnchorPane) loader.load();
			
			this.principal.setCenter(pessoaView);
			
			PessoaController controller = loader.getController();
			controller.setMain(this);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initMainStage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gui/conteiner.fxml"));
			this.principal = (BorderPane) loader.load();
			
			Scene cena = new Scene(this.principal);		
			
			this.primaryStage.setScene(cena);
			this.primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Pessoa> geDados() {
		return this.dados;
	}
}
