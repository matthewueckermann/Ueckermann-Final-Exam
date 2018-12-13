package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWorking;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label txtSaveEachMonth;
	
	@FXML
	private Label txtNeedSave;
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		
		txtAnnualReturnRetired.setText(""); //Iteration would be better, but hey it works
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		txtSaveEachMonth.setText("");
		txtNeedSave.setText("");
		
		System.out.println("Clear pressed");
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		Retirement r1 = new Retirement();
		
		
		
		
		r1.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnRetired.getText()));
		r1.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWorking.getText()));
		
		txtAnnualReturnRetired.setText(Double.toString(r1.getdAnnualReturnRetired()));
		txtAnnualReturnWorking.setText(Double.toString(r1.getdAnnualReturnWorking()));
		
		r1.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
		r1.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
		r1.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
		r1.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
		
		DecimalFormat dformat = new DecimalFormat("#.00"); // To truncate doubles when passed into labels 
		
		txtSaveEachMonth.setText("$\t"+ dformat.format(r1.AmountToSave()));
		txtNeedSave.setText("$\t"+ dformat.format(r1.TotalAmountSaved()));
		
	}
	
	
	/* 
	 Below is how I validated the information, definitely not the best but it gets the job done (I think)
	 These were added to on key released in scene builder, probably not the best place for them, but tests input
	 immediately, was not sure if there was a way to make it test input after clicking out of box.
	*/
	
	@FXML
	private void yearsToWorkEntry() {	
		try {
			if(txtYearsToWork.getText().equals("")) {
				
			}
			else {
				int value = Integer.parseInt(txtYearsToWork.getText());
			}
		}
		catch(Exception e) {
			txtYearsToWork.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Years to Work must be an Integer");
            alert.setContentText("Please enter an integer.");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void yearsRetiredEntry() {	
		try {
			if(txtYearsRetired.getText().equals("")) {
				
			}
			else {
				int value = Integer.parseInt(txtYearsRetired.getText());
			}
		}
		catch(Exception e) {
			txtYearsRetired.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Years Retired must be an Integer");
            alert.setContentText("Please enter an integer.");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void annualReturnWorkingEntry() {
		try {
			if(txtAnnualReturnWorking.getText().equals("")) {
				
			}
			else {
				double value = Double.parseDouble(txtAnnualReturnWorking.getText());
			}
		}
		catch(Exception e) {
			txtAnnualReturnWorking.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Annual Return Retired must be a double, in decimal form");
            alert.setContentText("Please enter the return in decimal format. Values over one will be assumed to be in percent form and will be converted when values calculated");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void annualReturnRetiredEntry() {
		try {
			if(txtAnnualReturnRetired.getText().equals("")) {
				
			}
			else {
				double value = Double.parseDouble(txtAnnualReturnRetired.getText());
			}
		}
		catch(Exception e) {
			txtAnnualReturnRetired.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Annual Return Retired must be a double, in decimal form");
            alert.setContentText("Please enter the return in decimal format. Values over one will be assumed to be in percent form and will be converted when values calculated");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void requiredIncomeEntry() {
		try {
			if(txtRequiredIncome.getText().equals("")) {
				
			}
			else {
				double value = Double.parseDouble(txtRequiredIncome.getText());
			}
		}
		catch(Exception e) {
			txtRequiredIncome.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Required Income must be a double");
            alert.setContentText("Please enter the Required Income as a number, with no other characters");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void monthlySSIEntry() {
		try {
			if(txtMonthlySSI.getText().equals("")) {
				
			}
			else {
				double value = Double.parseDouble(txtMonthlySSI.getText());
			}
		}
		catch(Exception e) {
			txtMonthlySSI.setText("");
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(((RetirementApp) mainApp).getPrimaryStage());
            alert.setTitle("Invalid input");
            alert.setHeaderText("Monthly SSI must be a double");
            alert.setContentText("Please enter the Monthly SSI as a number, with no other characters");
            alert.showAndWait();
		}
	}
	
}
