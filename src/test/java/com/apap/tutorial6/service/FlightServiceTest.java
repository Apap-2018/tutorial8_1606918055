package com.apap.tutorial6.service;

import static org.junit.Assert.assertThat;

import java.util.Optional;

import com.apap.tutorial6.Factory;
import com.apap.tutorial6.model.FlightModel;
import com.apap.tutorial6.repository.FlightDb;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @MockBean
    private FlightDb flightDb;

    @TestConfiguration
    static class FlightServiceTestContextConfiguration {
        @Bean
        public FlightService flightService() {
            return new FlightServiceImpl();
        }
    }

    @Test
    public void whenValidFlightNumberThenFlightShouldBeFound() {
        // given
        FlightModel flightModel = Factory.createFlightModel(null);
        Optional<FlightModel> fOptional = Optional.of(flightModel);
        Mockito.when(flightDb.findByFlightNumber(flightModel.getFlightNumber())).thenReturn(fOptional);

        // when
        Optional<FlightModel> found = flightService.getFlightDetailByFlightNumber(flightModel.getFlightNumber());

        // then
        assertThat(found, Matchers.notNullValue());
        assertThat(found.get().getFlightNumber(), Matchers.equalTo(flightModel.getFlightNumber()));
    }
}