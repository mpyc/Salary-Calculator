package Models;

import java.math.BigDecimal;

public class ContractWork {
    private BigDecimal gross;
    private BigDecimal costOfGettingIncome;
    private BigDecimal taxableIncome;
    private BigDecimal taxToBePaid;
    private BigDecimal net;

    public ContractWork(BigDecimal gross, BigDecimal costOfGettingIncomeInPercents) {
        this.gross = gross;
        this.costOfGettingIncome = gross.multiply(costOfGettingIncomeInPercents).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.taxableIncome = gross.subtract(costOfGettingIncome).setScale(0, BigDecimal.ROUND_HALF_UP);
        this.taxToBePaid = taxableIncome.multiply(new BigDecimal(0.18)).setScale(0, BigDecimal.ROUND_HALF_UP);
        this.net = gross.subtract(taxToBePaid);
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public BigDecimal getCostOfGettingIncome() {
        return costOfGettingIncome;
    }

    public void setCostOfGettingIncome(BigDecimal costOfGettingIncome) {
        this.costOfGettingIncome = costOfGettingIncome;
    }

    public BigDecimal getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(BigDecimal taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public BigDecimal getTaxToBePaid() {
        return taxToBePaid;
    }

    public void setTaxToBePaid(BigDecimal taxToBePaid) {
        this.taxToBePaid = taxToBePaid;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }
}
