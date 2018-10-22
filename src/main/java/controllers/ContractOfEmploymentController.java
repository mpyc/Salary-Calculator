package controllers;

import Models.EmploymentContract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContractOfEmploymentController {

    @FXML
    private TextField TextFieldGross1;
    @FXML
    private TextArea TextAreaInsurens_1;
    @FXML
    private TextField TextFieldCostOfGettingIncome_1;
    @FXML
    private TextField TextFieldTaxableIncome_1;
    @FXML
    private TextField TextFieldAdvance_1;
    @FXML
    private TextField TextFieldTaxRelif_1;
    @FXML
    private TextField TextFieldBasis_1;
    @FXML
    private TextArea TextAreaHealthInsurances_1;
    @FXML
    private TextField TextFieldDeductions_1;
    @FXML
    private TextField TextFieldTaxToPayed_1;
    @FXML
    private TextField TextFieldNet_1;
    @FXML
    private CheckBox checkBoxResidence;

    private BigDecimal gross;

    @FXML
    void CalculateNet(ActionEvent event) {
        String taxRelif = "46.33";
        EmploymentContract employmentContract = null;
        try {
            gross = new BigDecimal(TextFieldGross1.getText()).setScale(2, RoundingMode.HALF_UP);
            taxRelif = TextFieldTaxRelif_1.getText();
            employmentContract = new EmploymentContract(gross, checkBoxResidence.isSelected(), taxRelif);
            TextAreaInsurens_1.setText("Emerytalne: " + employmentContract.getPensionInsurance() + "\nRentowe: " + employmentContract.getDisabilityInsurance() + "\nChorobowe: " + employmentContract.getMedicalInsurance() +"\nŁącznie: " +employmentContract.getInsuranceInTotal());
            TextFieldCostOfGettingIncome_1.setText(String.valueOf(employmentContract.getCostOfGettingIncome()));
            TextFieldTaxableIncome_1.setText(String.valueOf(employmentContract.getTaxableIncome()));
            TextFieldAdvance_1.setText(String.valueOf(employmentContract.getAdvancePaymentForIncomeTax()));
            TextFieldTaxRelif_1.setText(String.valueOf(employmentContract.getTaxRelief()));
            TextFieldBasis_1.setText(String.valueOf(employmentContract.getBasisOfGrossTaxation()));
            TextAreaHealthInsurances_1.setText("Pobrane: " + employmentContract.getHealthInsuranceCollected() + "\nDo odliczenia: " + employmentContract.getHealthInsuranceForDeductionFromTax() + "\nFinansowane przez ubezpieczonego :" + employmentContract.getHealthInsureFinancedByInsured());
            TextFieldTaxToPayed_1.setText(String.valueOf(employmentContract.getTaxToBePaid()));
            TextFieldDeductions_1.setText(String.valueOf(employmentContract.getDeductionsTogether()));
            TextFieldNet_1.setText(String.valueOf(employmentContract.getNet()));
        } catch (NumberFormatException ex) {
            setTextInAll("Błąd");
        }catch (NullPointerException ex){
            setTextInAll("Błąd");
        }


        
    }
    @FXML
    void ResidenceChanged(ActionEvent event) {
        CalculateNet(event);
    }
    @FXML
    void TaxRelifAction(ActionEvent event) {
        CalculateNet(event);
    }

    void setTextInAll(String error){
        TextAreaInsurens_1.setText(error);
        TextFieldCostOfGettingIncome_1.setText(error);
        TextFieldTaxableIncome_1.setText(error);
        TextFieldAdvance_1.setText(error);
        TextFieldBasis_1.setText(error);
        TextAreaHealthInsurances_1.setText(error);
        TextFieldTaxToPayed_1.setText(error);
        TextFieldDeductions_1.setText(error);
        TextFieldNet_1.setText(error);
    }


}
