package service;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class InsuranceCalculation {


    public static BigDecimal pensionInsurance(BigDecimal gross){
        return new BigDecimal(0.0976).setScale(4, ROUND_HALF_UP).multiply(gross).setScale(2, ROUND_HALF_UP);
    }

    public static BigDecimal disabilityInsurance(BigDecimal gross){
        return new BigDecimal(0.015).setScale(4, ROUND_HALF_UP).multiply(gross).setScale(2, ROUND_HALF_UP);
    }
    public static BigDecimal medicalInsurance(BigDecimal gross){
        return new BigDecimal(0.0245).setScale(4, ROUND_HALF_UP).multiply(gross).setScale(2, ROUND_HALF_UP);
    }
}
