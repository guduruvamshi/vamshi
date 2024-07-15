package com.edubridge.washingmachine.dao;

import java.util.List;

import com.edubridge.washingmachine.model1.WashingMachine;

public interface WashingMachineDao {
	int addWashingMachine(WashingMachine w) ;
	List<WashingMachine>getAllWashingMachine();
	WashingMachine getWashingMachine(String name);
	int updateWashingMachine(WashingMachine w);
	int deleteWashingMachine(String name);
	void deleteAllWashingMachine();
    boolean checkModelExists(int modelno);
 
}
