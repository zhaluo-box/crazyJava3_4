package com.zhaluobox.designMode.builder;

import java.util.List;

public class BwmBuilder extends CarBuilder {

    private CarModel model = new BwmModel( "宝马" );

    @Override
    void setSequence(List<String> sequenceList) {
        model.setSequence( sequenceList );
    }

    @Override
    CarModel getCarModel() {
        return model;
    }
}
