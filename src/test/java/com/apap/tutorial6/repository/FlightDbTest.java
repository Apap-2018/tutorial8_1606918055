package com.apap.tutorial6.repository;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Optional;

import com.apap.tutorial6.Factory;
import com.apap.tutorial6.model.FlightModel;
import com.apap.tutorial6.model.PilotModel;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FlightDbTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlightDb flightDb;

    @Test
    public void whenFindByFlightNumberThenReturnFlight() {
        // given
        PilotModel pilotModel = Factory.createPilotModel();
        entityManager.persist(pilotModel);
        entityManager.flush();

        FlightModel flightModel = Factory.createFlightModel(pilotModel);
        entityManager.persist(flightModel);
        entityManager.flush();

        // when
        Optional<FlightModel> found = flightDb.findByFlightNumber("X550");

        // then
        assertTrue(found.isPresent());
        assertThat(found.get(), Matchers.notNullValue());
        assertThat(found.get(), Matchers.equalTo(flightModel));
    }
}
