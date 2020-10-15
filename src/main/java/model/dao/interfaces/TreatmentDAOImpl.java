package model.dao.interfaces;

import model.entity.Treatment;

/**
 * The interface Treatment dao.
 */
public interface TreatmentDAOImpl {
    /**
     * Find by id treatment.
     *
     * @param id the id
     * @return the treatment
     */
    Treatment findById(int id);
}
