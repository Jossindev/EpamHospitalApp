package service.impl;

import model.dao.AssignmentTypeDAOImpl;
import model.entity.AssignmentType;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

public class AssignmentTypeService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final AssignmentTypeDAOImpl assignmentTypeDAO = daoFactory.createAssignmentTypeDAO();

    public AssignmentTypeService() { }

    public AssignmentType findById(int id) {
        return assignmentTypeDAO.findById(id);
    }

    public List<AssignmentType> findAllType() {
        return assignmentTypeDAO.findAllType();
    }
}
