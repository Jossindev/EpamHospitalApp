package service.impl;

import model.dao.TreatmentDAOImpl;
import model.entity.Treatment;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

/**
 * The type Treatment service.
 */
public class TreatmentService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final TreatmentDAOImpl treatmentDAO = daoFactory.createTreatmentDao();

    /**
     * Instantiates a new Treatment service.
     */
    public TreatmentService() { }

    /**
     * Find treatment by id treatment.
     *
     * @param id the id
     * @return the treatment
     */
    public Treatment findTreatmentById(int id) {
        return treatmentDAO.findById(id);
    }
}
