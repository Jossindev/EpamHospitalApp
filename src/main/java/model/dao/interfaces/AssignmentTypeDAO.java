package model.dao.interfaces;

import model.entity.AssignmentType;

import java.util.List;

public interface AssignmentTypeDAO {
    AssignmentType findById(int id);

    List<AssignmentType> findAllType();
}
