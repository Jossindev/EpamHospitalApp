package utils.factory;

import model.dao.implementation.*;

public interface DaoFactory {
    AssignmentDAOImpl createAssignmentDao();
    TreatmentDAOImpl createTreatmentDao();
    RoleDAOImpl createRoleDao();
    UserDAOImpl createUserDao();
    DiagnosisDAOImpl createDiagnoseDao();
}
