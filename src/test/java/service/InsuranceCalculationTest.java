package service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceCalculationTest {



    @Test
    void PensionInsurance_GrossIsPositive_True(){
        assertEquals(0, new BigDecimal(97.60).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.pensionInsurance(new BigDecimal(1000))));
        assertEquals(0, new BigDecimal(10.84).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.pensionInsurance(new BigDecimal(111.11))));
        assertEquals(0, new BigDecimal(891.21).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.pensionInsurance(new BigDecimal(9131.21))));
    }

    @Test
    void DisabilityInsurance_GrossIsPositive_True(){
        assertEquals(0, new BigDecimal(15).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.disabilityInsurance(new BigDecimal(1000))));
        assertEquals(0, new BigDecimal(90).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.disabilityInsurance(new BigDecimal(6000))));
        assertEquals(0, new BigDecimal(1.67).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.disabilityInsurance(new BigDecimal(111.23))));
    }

    @Test
    void MedicalInsurance_GrossIsPositive_True(){
        assertEquals(0, new BigDecimal(2.73).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.medicalInsurance(new BigDecimal(111.23))));
        assertEquals(0, new BigDecimal(184.06).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.medicalInsurance(new BigDecimal(7512.66))));
        assertEquals(0, new BigDecimal(62.28).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(InsuranceCalculation.medicalInsurance(new BigDecimal(2541.88))));

    }


}