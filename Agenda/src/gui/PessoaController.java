package gui;

import application.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Pessoa;
import util.DateUtil;

public class PessoaController {
	
	@FXML
	private TableView<Pessoa> tabela;
	@FXML
	private TableColumn<Pessoa, String> colunaNome;
	@FXML
	private TableColumn<Pessoa, String> colunaSobrenomeNome;
	@FXML
	private Label rotuloNome;
	@FXML
	private Label rotuloSobreNome;
	@FXML
	private Label rotuloDataNascimento;
	
	private Main main;
	
	public PessoaController() {}
	
	@FXML
	private void initizalize() {
		colunaNome.setCellValueFactory(celula -> celula.getValue().nomeProperty());
		colunaSobrenomeNome.setCellValueFactory(celula -> celula.getValue().nomeProperty());
		
		mostraDetalhe(null);
		//Adicionando evento
		tabela.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> mostraDetalhe(newValue));
		
	}
	
	public void setMain(Main main) {
		this.main = main;
		this.tabela.setItems(main.geDados());
	}
	
	private void mostraDetalhe(Pessoa pessoa) {
		if(pessoa != null) {
			rotuloNome.setText(pessoa.getNome());
			rotuloSobreNome.setText(pessoa.getSobrenome());
			rotuloDataNascimento.setText(DateUtil.format(pessoa.getDataNascimento()));
		}else {
			rotuloNome.setText("");
			rotuloSobreNome.setText("");
			rotuloDataNascimento.setText("");
		}
	}
	
	

}
