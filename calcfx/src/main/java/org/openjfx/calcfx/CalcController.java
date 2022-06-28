package org.openjfx.calcfx;

import java.io.IOException;

import java.net.UnknownHostException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalcController {

	@FXML private Label label;
    @FXML private Button button0;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button buttonDot;
    @FXML private Button buttonEquals;
    @FXML private Button buttonPlus;
    @FXML private Button buttonMinus;
    @FXML private Button buttonMulti;
    @FXML private Button buttonDivide;
    @FXML private Button buttonAC;
    @FXML private Button buttonBrackets1;
    @FXML private Button buttonBrackets2;
    @FXML private Button buttonPercent;
    
    @FXML
 	public void handleButtonAction(ActionEvent event ) {
    	if(event.getSource()== button0)
    		label.setText(label.getText()+"0");
    	else if(event.getSource()== button1) 
    		label.setText(label.getText()+"1");	
    	else if(event.getSource()== button2) 
        	label.setText(label.getText()+"2");
    	else if(event.getSource()== button3) 
        	label.setText(label.getText()+"3");
    	else if(event.getSource()== button4) 
        	label.setText(label.getText()+"4");
    	else if(event.getSource()== button5) 
        	label.setText(label.getText()+"5");
    	else if(event.getSource()== button6) 
        	label.setText(label.getText()+"6");
    	else if(event.getSource()== button7) 
        	label.setText(label.getText()+"7");
    	else if(event.getSource()== button8) 
        	label.setText(label.getText()+"8");
    	else if(event.getSource()== button9) 
        	label.setText(label.getText()+"9");
    	else if(event.getSource()== buttonDot) 
        	label.setText(label.getText()+".");
    	else if(event.getSource()== buttonPlus) 
        	label.setText(label.getText()+"+");
    	else if(event.getSource()== buttonMinus) 
        	label.setText(label.getText()+"-");
    	else if(event.getSource()== buttonMulti) 
        	label.setText(label.getText()+"*");
    	else if(event.getSource()== buttonDivide) 
        	label.setText(label.getText()+"/");
    	else if(event.getSource()== buttonPercent) 
        	label.setText(label.getText()+"%");
    	else if(event.getSource()== buttonBrackets1) 
        	label.setText(label.getText()+"(");
    	else if(event.getSource()== buttonBrackets2) 
        	label.setText(label.getText()+")");
    	else if(event.getSource()== buttonAC) 
        	label.setText("");
 	}
    
    @FXML
 	public void handleButtonEquals() throws UnknownHostException, IOException {
    	String valueToSend;
    	valueToSend = label.getText();
    	System.out.println(valueToSend);
    		
    	NetClient client = new NetClient("localhost", 9001);
    	label.setText(client.getResponse(valueToSend));
    	try {
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}
