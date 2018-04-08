package com.github.kadesnikov.du1.ui;


import com.github.kadesnikov.du1.logika.Hra;
import com.github.kadesnikov.du1.main.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class Controller {
	private Hra hra;
	
	@FXML private Button  	bear;
	@FXML private Button  	cow;
	@FXML private Button  	monkey;
	@FXML private Button  	dolphin;
	@FXML private Button  	horse;
	@FXML private Button  	butterfly;
	@FXML private Button  	hadej;
	
	@FXML private Label label;
	
	@FXML private ImageView picture1;
	@FXML private ImageView picture2;
	@FXML private ImageView picture3;
	@FXML private ImageView picture4;
	@FXML private ImageView picture5;
	@FXML private ImageView picture6;
	
	@FXML private Tooltip  	t1;
	@FXML private Tooltip  	t2;
	@FXML private Tooltip  	t3;
	@FXML private Tooltip  	t4;
	@FXML private Tooltip  	t5;
	@FXML private Tooltip  	t6;

	@FXML private TextArea	textVystup;
	
	private boolean povoleni = false;
	
	public void inicializuj(Hra hra, Start start) {
		this.hra = hra;
	}
	
	public void odesliPrikaz() {
		textVystup.clear();
		String odpoved = 	"Počet správných odpovědí: " + hra.getSpravne() + "\n" +
							"Počet špatných odpovědí: " + hra.getSpatne();
		textVystup.appendText(odpoved);
	}
	
	
	@FXML public void click(ActionEvent arg0) {

			hra.vyberSlovo();
			String slovo = hra.getGuessed();
			label.setText(slovo);
			povoleni = true;
		
	}
	
	@FXML public void hadej(ActionEvent arg0) {
		if (povoleni) {
			
			String guess = ((Node) arg0.getTarget()).getId();
			if (label.getText().equals(guess)) {
				hra.setScore(guess);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Oznamení");
				alert.setHeaderText(null);
				alert.setContentText("Správné!");
				alert.showAndWait();
				label.setText("");
			}
			else 
			{   label.setText("");
				hra.setScore(guess);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Oznamení");
				alert.setHeaderText("Špatně! Zkus ještě jednou.");
				alert.showAndWait();
			}
		povoleni = false;
		hadej.setText("Hadej");
		this.odesliPrikaz();
		}
	}
	
	
	

}
