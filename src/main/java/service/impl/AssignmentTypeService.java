package service.impl;

import model.dao.AssignmentTypeDAOImpl;
import model.entity.AssignmentType;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

/**
 * The type Assignment type service.
 */
public class AssignmentTypeService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final AssignmentTypeDAOImpl assignmentTypeDAO = daoFactory.createAssignmentTypeDAO();

    /**
     * Instantiates a new Assignment type service.
     */
    public AssignmentTypeService() { }

    /**
     * Find by id assignment type.
     *
     * @param id the id
     * @return the assignment type
     */
    public AssignmentType findById(int id) {
        return assignmentTypeDAO.findById(id);
    }

    /**
     * Find all type list.
     *
     * @return the list
     */
    public List<AssignmentType> findAllType() {
        return assignmentTypeDAO.findAllType();
    }
}
