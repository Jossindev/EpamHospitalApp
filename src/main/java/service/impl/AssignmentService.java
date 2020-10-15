package service.impl;

import model.dao.AssignmentDAOImpl;
import model.entity.Assignment;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;


/**
 * The type Assignment service.
 */
public class AssignmentService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final AssignmentDAOImpl assignmentDAO = daoFactory.createAssignmentDao();

    /**
     * Instantiates a new Assignment service.
     */
    public AssignmentService() { }

    /**
     * Find assignment by id assignment.
     *
     * @param id the id
     * @return the assignment
     */
    public Assignment findAssignmentById(int id) {
        return assignmentDAO.findById(id);
    }

    /**
     * Update assignment executor.
     *
     * @param executorId the executor id
     * @param id         the id
     */
    public void updateAssignmentExecutor(int executorId, int id) {
        assignmentDAO.updateAssignmentExecutor(executorId, id);
    }

    /**
     * Update assignment reporter.
     *
     * @param reporterId  the reporter id
     * @param id          the id
     * @param description the description
     */
    public void updateAssignmentReporter(int reporterId, int id, String description) {
        assignmentDAO.updateAssignmentReporter(reporterId, id, description);
    }
}
