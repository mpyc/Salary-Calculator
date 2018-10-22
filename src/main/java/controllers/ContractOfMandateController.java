package controllers;

import Models.ContractOfMandate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class ContractOfMandateController {

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
    private TextField TextFieldBasis_1;
    @FXML
    private TextArea TextAreaHealthInsurances_1;
    @FXML
    private TextField TextFieldDeductions_1;
    @FXML
    private TextField TextFieldTaxToPayed_1;
    @FXML
    private TextField TextFieldNet_1;

    private BigDecimal gross;

    @FXML
    void CalculateNet(ActionEvent event) {
        ContractOfMandate contractOfMandate = null;
        try{
            gross = new BigDecimal(TextFieldGross1.getText()).setScale(2, BigDecimal.ROUND_HALF_UP);
            contractOfMandate = new ContractOfMandate(gross);
            TextAreaInsurens_1.setText("Emerytalne: " + contractOfMandate.getPensionInsurance() + "\nRentowe: " + contractOfMandate.getDisabilityInsurance()  +"\nŁącznie: " +contractOfMandate.getInsuranceInTotal());
            TextFieldCostOfGettingIncome_1.setText(String.valueOf(contractOfMandate.getCostOfGettingIncome()));
            TextFieldTaxableIncome_1.setText(String.valueOf(contractOfMandate.getTaxableIncome()));
            TextFieldAdvance_1.setText(String.valueOf(contractOfMandate.getAdvancePaymentForIncomeTax()));
            TextFieldBasis_1.setText(String.valueOf(contractOfMandate.getBasisOfGrossTaxation()));
            TextAreaHealthInsurances_1.setText("Pobrane: " + contractOfMandate.getHealthInsuranceCollected() + "\nDo odliczenia: " + contractOfMandate.getHealthInsuranceForDeductionFromTax() + "\nFinansowane przez ubezpieczonego :" + contractOfMandate.getHealthInsureFinancedByInsured());
            TextFieldTaxToPayed_1.setText(String.valueOf(contractOfMandate.getTaxToBePaid()));
            TextFieldDeductions_1.setText(String.valueOf(contractOfMandate.getDeductionsTogether()));
            TextFieldNet_1.setText(String.valueOf(contractOfMandate.getNet()));
        }
        catch (NumberFormatException ex) {
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
