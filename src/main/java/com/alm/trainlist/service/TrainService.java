
package com.alm.trainlist.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.alm.trainlist.entity.TrainEntity;

@Stateless
public class TrainService {

    @PersistenceContext(unitName = "JSF_CRUD_PU")
    private EntityManager entityManager;

   public void saveTrain(TrainEntity train) {
    entityManager.persist(train);
        List<TrainEntity> trainList = getAllTrains();
    }
    public TrainEntity getTrainById(Long id) {
        return entityManager.find(TrainEntity.class, id);
    }
    public List<TrainEntity> getAllTrains() {
        return entityManager.createQuery("SELECT t FROM com.alm.trainlist.entity.TrainEntity t", TrainEntity.class).getResultList();
    }

   public void updateTrain(TrainEntity train) {
       entityManager.merge(train);
    }
    public void deleteTrain(TrainEntity train) {
        entityManager.remove(entityManager.contains(train) ? train : entityManager.merge(train));
    }
  }
