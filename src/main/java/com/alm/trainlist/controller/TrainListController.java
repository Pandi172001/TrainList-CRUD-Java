
package com.alm.trainlist.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import com.alm.trainlist.entity.TrainEntity;
import com.alm.trainlist.service.TrainService;
import javax.inject.Inject;


@ManagedBean
@ViewScoped
public class TrainListController implements Serializable {
    private TrainEntity train = new TrainEntity();
    private List<TrainEntity> trainList;
    private boolean isUpdating;
   
    @Inject
    private TrainService trainService;

    public void saveTrain() {
        System.out.println("com.alm.trainlist.controller.TrainListController.saveTrain()");
        if(train.getId() == null){
            trainService.saveTrain(train);
        } 
        
        else{
            trainService.updateTrain(train);
        }
        train = new TrainEntity();
        trainList = trainService.getAllTrains(); 
        System.out.println("save success");
    }
    public void updateTrain(TrainEntity train){
        System.out.println(train.getLocation()+" "+train.getTrainName());
        setTrain(train);
    }
    
    public void update(TrainEntity train) {
    System.out.println(train.getLocation()+" "+train.getTrainName());
    setTrain(train); 
  }
    
    public void deleteTrain(TrainEntity train) {
        if (train != null) {
            trainService.deleteTrain(train);
            trainList.remove(train); 
        }
    }
    public TrainEntity getTrain() {
        return train;
    }
    public void setTrain(TrainEntity train) {
    this.train = train; 
   }

    public List<TrainEntity> getTrainList() {
        if (trainList == null) {
            trainList = trainService.getAllTrains();
        }
        return trainList;
    } 
 }
