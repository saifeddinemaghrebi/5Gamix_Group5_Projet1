//package tn.esprit.spring;

/*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IInstructorRepository;
import tn.esprit.spring.services.InstructorServicesImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InstructorServicesImplTest {

    @Mock
    private IInstructorRepository instructorRepository;

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private InstructorServicesImpl instructorServices;

    private Instructor mockInstructor;

    @BeforeEach
    public void setup() {
        // Initialize a common mock Instructor object for tests
        mockInstructor = new Instructor();
        mockInstructor.setNumInstructor(1L);
        mockInstructor.setFirstName("Karim");
        mockInstructor.setLastName("Abidi");
    }

    @Test
    public void testRetrieveInstructor() {
        // Mocking the behavior of instructorRepository.findById() method
        when(instructorRepository.findById(1L)).thenReturn(Optional.of(mockInstructor));

        // Performing the test
        Instructor retrievedInstructor = instructorServices.retrieveInstructor(1L);

        // Assertions
        assertNotNull(retrievedInstructor);
        assertEquals("Karim", retrievedInstructor.getFirstName());
        assertEquals("Abidi", retrievedInstructor.getLastName());
        assertEquals(1L, retrievedInstructor.getNumInstructor());
    }

    @Test
    public void testAddInstructor() {
        // Mocking the behavior of instructorRepository.save() method
        when(instructorRepository.save(mockInstructor)).thenReturn(mockInstructor);

        // Performing the test
        Instructor addedInstructor = instructorServices.addInstructor(mockInstructor);

        // Assertions
        assertNotNull(addedInstructor);
        assertEquals("Karim", addedInstructor.getFirstName());
        assertEquals("Abidi", addedInstructor.getLastName());
        assertEquals(1L, addedInstructor.getNumInstructor());
    }


}*/

