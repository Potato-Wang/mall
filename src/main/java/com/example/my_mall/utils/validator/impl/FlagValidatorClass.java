package com.example.my_mall.utils.validator.impl;

import com.example.my_mall.utils.validator.FlagValidator;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sun.font.TrueTypeFont;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {

    private String[] values;

    @Override
    public void initialize(FlagValidator flagValidator){
        this.values = flagValidator.value();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag = false;
        if(integer==null){
            return true;
        }
        for(int i =0; i<values.length; i++){
            if(values[i].equals(String.valueOf(integer))){
                flag = true;
                break;
            }
        }

        return flag;
    }
}
