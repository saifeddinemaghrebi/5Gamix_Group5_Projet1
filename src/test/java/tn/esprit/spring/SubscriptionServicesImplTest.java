package tn.esprit.spring;
import java.util.Date;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SubscriptionServicesImplTest {
    @Mock
    ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServicesImpl subscriptionServicesImpl;

    Subscription subscription = new Subscription(1L, LocalDate.now(), LocalDate.of(2025, 1, 1), 10f,
            TypeSubscription.ANNUAL);

    @Test
    public void testAddSubscription() {
        Mockito.when(subscriptionRepository.save(subscription)).thenReturn(subscription);

        Subscription subscription1 = subscriptionServicesImpl.addSubscription(subscription);

        Assertions.assertNotNull(subscription1);
    }
}