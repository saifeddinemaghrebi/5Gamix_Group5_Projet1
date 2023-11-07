package tn.esprit.spring.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestSkierMock {
    @InjectMocks
    private ISkierService SkierServiceImpl;

    @Mock
    private ISkierRepository ISkierRepository;

    @Test
    public void testUpdateSkier() {
        Skier skier = new Skier();
        skier.setNumSkier(1L);
        skier.setFirstName("Updated First Name");
        skier.setLastName("Updated Last Name");
        skier.setDateOfBirth(LocalDate.of(1995, 8, 20));
        skier.setCity("Updated City");

        when(skierRepository.save(skier)).thenReturn(skier);

        Skier result = skierService.updateSkier(skier);

        assertEquals(skier.getFirstName(), result.getFirstName());
        assertEquals(skier.getLastName(), result.getLastName());
        assertEquals(skier.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(skier.getCity(), result.getCity());
    }
}
