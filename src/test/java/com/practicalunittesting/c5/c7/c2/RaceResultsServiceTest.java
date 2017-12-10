package com.practicalunittesting.c5.c7.c2;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    private Logger logger = mock(Logger.class);
    private RaceResultsService raceResults = new RaceResultsService(logger);

    private Message horseMessage = mock(Message.class);
    private Message f1Message = mock(Message.class);
    private Message boatMessage = mock(Message.class);

    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(horseMessage, RaceCategory.HORSE);

        verify(clientA, never()).receive(horseMessage);
        verify(clientB, never()).receive(horseMessage);
    }

    @Test
    public void subscribedClientShouldReceiveSelectedCategoryMessage() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.addSubscriber(clientA, RaceCategory.F1);

        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(f1Message, RaceCategory.F1);
        raceResults.send(boatMessage, RaceCategory.BOAT);

        verify(clientA).receive(horseMessage);
        verify(clientA).receive(f1Message);
        verify(clientA, never()).receive(boatMessage);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.addSubscriber(clientB, RaceCategory.HORSE);

        raceResults.send(horseMessage, RaceCategory.HORSE);

        verify(clientA).receive(horseMessage);
        verify(clientB).receive(horseMessage);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);

        raceResults.send(horseMessage, RaceCategory.HORSE);

        verify(clientA).receive(horseMessage);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.removeSubscriber(clientA, RaceCategory.HORSE);

        raceResults.send(horseMessage, RaceCategory.HORSE);

        verify(clientA, never()).receive(horseMessage);
    }

    @Test
    public void eachMessageShouldBeLogged() {
        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.F1);
        raceResults.send(f1Message, RaceCategory.BOAT);

        verify(logger, times(2)).log(horseMessage);
        verify(logger).log(f1Message);
    }
}
