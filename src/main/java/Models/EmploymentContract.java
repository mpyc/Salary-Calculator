package Models;

import service.InsuranceCalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class EmploymentContract {

    public EmploymentContract(BigDecimal gross, boolean costOfGettingIncomeCheckBox, String taxRelif) {

        this.gross = gross;
        this.taxRelief= new BigDecimal(taxRelif).setScale(2, ROUND_HALF_UP);
        this.disabilityInsurance = InsuranceCalculation.disabilityInsurance(gross);
        this.medicalInsurance = InsuranceCalculation.medicalInsurance(gross);
        this.pensionInsurance = InsuranceCalculation.pensionInsurance(gross);
        this.insuranceInTotal = disabilityInsurance.add(medicalInsurance).add(pensionInsurance);
        this.costOfGettingIncome = costOfGettingIncomeCheckBox? new BigDecimal(139.09).setScale(2, ROUND_HALF_UP) : new BigDecimal(111.25).setScale(2, ROUND_HALF_UP);
        this.taxableIncome = gross.subtract(insuranceInTotal).subtract(costOfGettingIncome).setScale(2,RoundingMode.HALF_UP);
        this.advancePaymentForIncomeTax = new BigDecimal(0.18).multiply(taxableIncome).setScale(2, ROUND_HALF_UP);
        this.basisOfGrossTaxation = gross.subtract(insuranceInTotal).setScale(2, ROUND_HALF_UP);
        this.healthInsuranceCollected = healthInsuranceCollectedMethod();
        this.healthInsuranceForDeductionFromTax = healthInsuranceForDeductionFromTaxMethod();
        this.healthInsureFinancedByInsured = healthInsuranceCollected.subtract(healthInsuranceForDeductionFromTax);
        this.taxToBePaid = taxToBePaidMethod();
        this.deductionsTogether = insuranceInTotal.add(healthInsuranceCollected).add(taxToBePaid);
        this.net = gross.subtract(deductionsTogether);
    }

    private BigDecimal gross;
    private BigDecimal disabilityInsurance;
    private BigDecimal medicalInsurance;
    private BigDecimal pensionInsurance;
    //2 ubezpiecznie total
    private BigDecimal insuranceInTotal;
    //3 koszty uzyskania przychodu
    private  BigDecimal costOfGettingIncome;
    //4 dochod do opodatkowania
    private BigDecimal taxableIncome;
    //5 zaliczka na podatek dochodowy
    private BigDecimal advancePaymentForIncomeTax;
    //6 ulga podatkowa
    private BigDecimal taxRelief;
    //7 Podstawa opodatkowania brutto
    private BigDecimal basisOfGrossTaxation;
    //8 Ubezpieczenie zdrowotne - pobrane
    private BigDecimal healthInsuranceCollected;
    //9 Ubezpieczenie zdrowotne - do odliczenia od podatku
    private BigDecimal healthInsuranceForDeductionFromTax;
    //10 Ubezpieczenie zdrowotne - finansowane przez ubezpieczonego
    private BigDecimal healthInsureFinancedByInsured;
    //11 Podatek do zapłaty
    private BigDecimal taxToBePaid;
    //12 Potrącenia razem
    private BigDecimal deductionsTogether;
    //13 Do wypłaty Netto
    private BigDecimal net;

    public EmploymentContract() {

    }

    private BigDecimal healthInsuranceCollectedMethod() {

        if ((basisOfGrossTaxation.multiply(new BigDecimal(0.09)).
                compareTo(advancePaymentForIncomeTax.subtract(taxRelief)) > 0)) {
            return advancePaymentForIncomeTax.subtract(taxRelief).setScale(2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        } else {
            return basisOfGrossTaxation.multiply(new BigDecimal(0.09).setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal healthInsuranceForDeductionFromTaxMethod() {
        if (basisOfGrossTaxation.multiply(new BigDecimal(0.075)).compareTo(healthInsuranceCollected) > 0) {
            return healthInsuranceCollected;
        } else {
            return basisOfGrossTaxation.multiply(new BigDecimal(0.0775)).setScale(2, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal taxToBePaidMethod() {
        if (advancePaymentForIncomeTax.subtract(taxRelief).subtract(healthInsuranceForDeductionFromTax).compareTo(new BigDecimal(0).setScale(0, ROUND_HALF_UP)) > 0) {
            return advancePaymentForIncomeTax.subtract(taxRelief).subtract(healthInsuranceForDeductionFromTax).setScale(0,ROUND_HALF_UP);
        } else {
            return new BigDecimal(0).setScale(0, ROUND_HALF_UP).setScale(0, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getDisabilityInsurance() {
        return disabilityInsurance;
    }

    public void setDisabilityInsurance(BigDecimal disabilityInsurance) {
        this.disabilityInsurance = disabilityInsurance;
    }

    public BigDecimal getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(BigDecimal medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public BigDecimal getPensionInsurance() {
        return pensionInsurance;
    }

    public void setPensionInsurance(BigDecimal pensionInsurance) {
        this.pensionInsurance = pensionInsurance;
    }

    public BigDecimal getInsuranceInTotal() {
        return insuranceInTotal;
    }

    public void setInsuranceInTotal(BigDecimal insuranceInTotal) {
        this.insuranceInTotal = insuranceInTotal;
    }

    public BigDecimal getCostOfGettingIncome() {
        return costOfGettingIncome;
    }

    public BigDecimal getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(BigDecimal taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public BigDecimal getAdvancePaymentForIncomeTax() {
        return advancePaymentForIncomeTax;
    }

    public void setAdvancePaymentForIncomeTax(BigDecimal advancePaymentForIncomeTax) {
        this.advancePaymentForIncomeTax = advancePaymentForIncomeTax;
    }

    public BigDecimal getTaxRelief() {
        return taxRelief;
    }

    public BigDecimal getBasisOfGrossTaxation() {
        return basisOfGrossTaxation;
    }

    public void setBasisOfGrossTaxation(BigDecimal basisOfGrossTaxation) {
        this.basisOfGrossTaxation = basisOfGrossTaxation;
    }

    public BigDecimal getHealthInsuranceCollected() {
        return healthInsuranceCollected;
    }

    public void setHealthInsuranceCollected(BigDecimal healthInsuranceCollected) {
        this.healthInsuranceCollected = healthInsuranceCollected;
    }

    public BigDecimal getHealthInsuranceForDeductionFromTax() {
        return healthInsuranceForDeductionFromTax;
    }

    public void setHealthInsuranceForDeductionFromTax(BigDecimal healthInsuranceForDeductionFromTax) {
        this.healthInsuranceForDeductionFromTax = healthInsuranceForDeductionFromTax;
    }

    public BigDecimal getHealthInsureFinancedByInsured() {
        return healthInsureFinancedByInsured;
    }

    public void setHealthInsureFinancedByInsured(BigDecimal healthInsureFinancedByInsured) {
        this.healthInsureFinancedByInsured = healthInsureFinancedByInsured;
    }

    public BigDecimal getTaxToBePaid() {
        return taxToBePaid;
    }

    public void setTaxToBePaid(BigDecimal taxToBePaid) {
        this.taxToBePaid = taxToBePaid;
    }

    public BigDecimal getDeductionsTogether() {
        return deductionsTogether;
    }

    public void setDeductionsTogether(BigDecimal deductionsTogether) {
        this.deductionsTogether = deductionsTogether;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }
}
