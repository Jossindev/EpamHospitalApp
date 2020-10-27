package serviceTest;

import model.entity.Assignment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.AssignmentService;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AssignmentServiceTest {

    @Mock
    AssignmentService service;

    Assignment assignment;
    List<Assignment> assignments = new ArrayList<>();

    @Before
    public void setUp() {
        assignment = new Assignment(1);
        assignments.add(assignment);
    }

    @Test
    public void findAssignmentTest() {
        Mockito.when(service.findAssignmentById(1)).thenReturn(assignment);
    }
}
