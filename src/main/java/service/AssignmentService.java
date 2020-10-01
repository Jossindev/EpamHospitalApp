package service;

import model.dao.AssignmentDAOImpl;
import model.entity.Assignment;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;


public class AssignmentService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final AssignmentDAOImpl assignmentDAO = daoFactory.createAssignmentDao();

    public AssignmentService() {
    }

    public Assignment findAssignmentById(int id) {
        return assignmentDAO.findById(id);
    }

    public void updateAssignmentExecutor(int executorId, int id) {
        assignmentDAO.updateAssignmentExecutor(executorId, id);
    }

    public void updateAssignmentReporter(int reporterId, int id) {
        assignmentDAO.updateAssignmentReporter(reporterId, id);
    }
}
