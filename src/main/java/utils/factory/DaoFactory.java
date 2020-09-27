package utils.factory;

import model.dao.repository.*;

public interface DaoFactory {
    AssignmentDAOImpl createAssignmentDao();
    TreatmentDAOImpl createTreatmentDao();
    RoleDAOImpl createRoleDao();
    UserDAOImpl createUserDao();
    DiagnosisDAOImpl createDiagnoseDao();
}
