package com.apap.tutorial6;

import java.sql.Date;

import com.apap.tutorial6.model.FlightModel;
import com.apap.tutorial6.model.PilotModel;

public class Factory {

    public static PilotModel createPilotModel() {
        PilotModel pilotModel = new PilotModel();
        pilotModel.setLicenseNumber("4172");
        pilotModel.setName("Coki");
        pilotModel.setFlyHour(59);
        return pilotModel;
    } 
    public static FlightModel createFlightModel(PilotModel pilotModel) {
        FlightModel flightModel = new FlightModel();
        flightModel.setFlightNumber("X550");
        flightModel.setOrigin("Depok");
        flightModel.setDestination("Bekasi");
        flightModel.setTime(new Date(new java.util.Date().getTime()));
        flightModel.setPilot(pilotModel);
        return flightModel;
    }
}