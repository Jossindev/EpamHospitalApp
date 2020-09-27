package model.dao.interfaces;

import model.entity.Assignment;

public interface AssignmentDAO {
    Assignment findById(int id);

    void updateAssignmentExecutor(int executorId, int id);

    void updateAssignmentReporter(int reporterId, int id);
}
