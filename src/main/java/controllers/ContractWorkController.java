package controllers;

import Models.ContractWork;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;

public class ContractWorkController {

    @FXML
    private AnchorPane ContractOfEmployment;

    @FXML
    private TextField TextFieldGross1;

    @FXML
    private TextField TextFieldCostOfGettingIncome_1;

    @FXML
    private TextField TextFieldTaxableIncome_1;

    @FXML
    private TextField TextFieldNet_1;
    @FXML
    private ChoiceBox<String> choiceBoxCostOfGettingIncome;
    @FXML
    private TextField TextFieldTaxToPayed;

    private BigDecimal gross = null;
    private BigDecimal costOfGettingIncomeinPercents = null;



    @FXML
    void CalculateNet(ActionEvent event) {
        ContractWork contractWork = null;
        try {
            gross = new BigDecimal(TextFieldGross1.getText()).setScale(2, BigDecimal.ROUND_HALF_UP);
            costOfGettingIncomeinPercents = new BigDecimal(Integer.valueOf(getSubstring())).divide(BigDecimal.valueOf(100));
            contractWork = new ContractWork(gross, costOfGettingIncomeinPercents);
            TextFieldCostOfGettingIncome_1.setText(String.valueOf(contractWork.getCostOfGettingIncome()));
            TextFieldTaxableIncome_1.setText(String.valueOf(contractWork.getTaxableIncome()));
            TextFieldTaxToPayed.setText(String.valueOf(contractWork.getTaxToBePaid()));
            TextFieldNet_1.setText(String.valueOf(contractWork.getNet()));
        } catch (NumberFormatException ex) {
            setTextInAll("Błąd");
        } catch (NullPointerException ex) {
            setTextInAll("Błąd");
        }
    }


    private String getSubstring() {
        return choiceBoxCostOfGettingIncome.getValue().substring(0, choiceBoxCostOfGettingIncome.getValue().length() - 1);
    }



    void setTextInAll(String error) {
        TextFieldCostOfGettingIncome_1.setText(error);
        TextFieldTaxableIncome_1.setText(error);
        TextFieldNet_1.setText(error);
    }


}
