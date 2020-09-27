package model.dao.interfaces;

import model.entity.Treatment;

public interface TreatmentDAOImpl {
    Treatment findById(int id);
}
