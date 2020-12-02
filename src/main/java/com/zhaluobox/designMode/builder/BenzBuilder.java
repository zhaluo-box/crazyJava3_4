package com.zhaluobox.designMode.builder;

import java.util.List;

public class BenzBuilder  extends CarBuilder{
    private CarModel model  =  new BenzModel( "奔驰" );


    @Override
    void setSequence(List<String> sequenceList) {
        model.setSequence( sequenceList );
    }

    @Override
    CarModel getCarModel() {
        return this.model;
    }
}
