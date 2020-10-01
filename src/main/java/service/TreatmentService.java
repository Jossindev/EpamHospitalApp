package service;

import model.dao.TreatmentDAOImpl;
import model.entity.Treatment;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

public class TreatmentService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final TreatmentDAOImpl treatmentDAO = daoFactory.createTreatmentDao();

    public TreatmentService() {
    }

    public Treatment findTreatmentById(int id) {
        return treatmentDAO.findById(id);
    }
}
