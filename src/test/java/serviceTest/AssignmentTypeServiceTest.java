package serviceTest;

import model.entity.AssignmentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.AssignmentTypeService;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AssignmentTypeServiceTest {

    @Mock
    AssignmentTypeService service;

    AssignmentType type;
    List<AssignmentType> types = new ArrayList<>();

    @Before
    public void setUp() {
      type = new AssignmentType(1,"firstType");
      types.add(type);
    }

    @Test
    public void findAllTypesTest() {
        Mockito.when(service.findAllType()).thenReturn(types);
    }

    @Test
    public void findTypeByIdTest() {
        Mockito.when(service.findById(1)).thenReturn(type);
    }

}
