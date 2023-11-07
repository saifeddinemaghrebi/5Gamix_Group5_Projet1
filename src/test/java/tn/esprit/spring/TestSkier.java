/*
package tn.esprit.spring.entities;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestSkier {
    @Autowired
    private ISkierService SkierServiceImpl;

    @Autowired
    private ISkierRepository ISkierRepository;

    @Test
    public void testAddSkier() {
        Skier skier = new Skier();
        skier.setFirstName("John");
        skier.setLastName("Doe");
        skier.setDateOfBirth(LocalDate.of(1990, 5, 15));
        skier.setCity("New York");

        Skier result = skierService.addSkier(skier);

        Skier fetchedSkier = skierRepository.findById(result.getNumSkier()).orElse(null);
        assertEquals(skier.getFirstName(), fetchedSkier.getFirstName());
        assertEquals(skier.getLastName(), fetchedSkier.getLastName());
        assertEquals(skier.getDateOfBirth(), fetchedSkier.getDateOfBirth());
        assertEquals(skier.getCity(), fetchedSkier.getCity());
    }
}
*/
