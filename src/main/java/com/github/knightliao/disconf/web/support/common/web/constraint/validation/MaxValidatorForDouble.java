package com.github.knightliao.disconf.web.support.common.web.constraint.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.knightliao.disconf.web.support.common.web.constraint.DoubleMax;

/**
 * @author liaoqiqi
 */
public class MaxValidatorForDouble implements ConstraintValidator<DoubleMax, Double> {

    private double maxValue;

    public void initialize(DoubleMax maxValue) {
        this.maxValue = maxValue.value();
    }

    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {

        // null values are valid
        if (value == null) {
            return true;
        }

        BigDecimal premium = BigDecimal.valueOf(value);
        BigDecimal netToCompany = BigDecimal.valueOf(maxValue);

        BigDecimal commission = premium.subtract(netToCompany);

        return commission.compareTo(BigDecimal.ZERO) <= 0;
    }
}