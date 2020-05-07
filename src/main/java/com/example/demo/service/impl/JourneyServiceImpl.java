package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Journey;
import com.example.demo.entity.Trip;
import com.example.demo.repository.JourneyRepository;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.JourneyService;
import com.example.demo.service.search.JourneySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {

    final
    JourneyRepository journeyRepository;
    final
    TripRepository tripRepository;


    @Autowired
    public JourneyServiceImpl(JourneyRepository JourneyRepository, TripRepository tripRepository) {
        this.journeyRepository = JourneyRepository;
        this.tripRepository = tripRepository;
    }

    /**
     * Пошук прамих подорожів з точки А в точку Б.
     * @param journeySearch
     * @return
     */
    @Override
    public List<Journey> search(JourneySearch journeySearch) {
        return journeyRepository.findJourneyByFromAndToStations(journeySearch.getFromStationId(),
                journeySearch.getToStationId());
    }

    @Override
    public Journey save(Journey journey, List<Trip> trips) {
        validateTrips(trips);
        if (journey.getId() != null) {
            tripRepository.removeTripsByJourneyId(journey.getId()); //Удяляємо всі дочірні поїздки
        }
        journey = journeyRepository.save(journey);
        Journey finalJourney = journey;
        trips.forEach(e -> e.setJourney(finalJourney));

        tripRepository.saveAll(trips);
        return journey;
    }


    /**
     * Валідація поїздок на валідність по часу та станціях
     *
     * @param trips
     */
    private void validateTrips(List<Trip> trips) {
        if (trips.isEmpty()) throw new IllegalArgumentException("Trips could not be empty");
        trips.sort(Comparator.comparing(Trip::getDateOfDeparture));
        Trip lastTrip = null;
        for (Trip trip : trips) {
            if (lastTrip == null) {
                lastTrip = trip;
                continue;
            }
            if (!lastTrip.getTo().getId().equals(trip.getFrom().getId()))
                throw new IllegalArgumentException("Trip stations order is impossible");
            if (lastTrip.getDateOfDeparture().plusDays(lastTrip.getDuration())
                    .isAfter(trip.getDateOfDeparture()))
                throw new IllegalArgumentException("Trip time is impossible");
        }
    }

    @Override
    public void deleteById(Long id) {
        if (!journeyRepository.existsById(id)) throw new ResourceNotFoundException();
        journeyRepository.deleteById(id);
    }

    @Override
    public Journey findById(Long id) {
        return journeyRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Journey> findAll() {
        return journeyRepository.findAll();
    }
}
