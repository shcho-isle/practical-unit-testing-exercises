package com.practicalunittesting.c5.c7.c2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

@PrepareForTest(RaceResultsService.class)
@RunWith(PowerMockRunner.class)
public class RaceResultsServiceTest {

    private Logger logger = PowerMockito.mock(Logger.class);
    private RaceResultsService raceResults = new RaceResultsService(logger);

    private Message horseMessage = mock(Message.class);
    private Message f1Message = mock(Message.class);
    private Message boatMessage = mock(Message.class);

    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.F1);

        verify(clientA, never()).receive(horseMessage);
        verify(clientB, never()).receive(horseMessage);
    }

    @Test
    public void subscribedClientShouldReceiveSelectedCategoryMessage() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.addSubscriber(clientA, RaceCategory.F1);

        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(f1Message, RaceCategory.F1);
        raceResults.send(f1Message, RaceCategory.F1);
        raceResults.send(boatMessage, RaceCategory.BOAT);
        raceResults.send(boatMessage, RaceCategory.BOAT);

        verify(clientA, times(2)).receive(horseMessage);
        verify(clientA, times(2)).receive(f1Message);
        verify(clientA, never()).receive(boatMessage);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.addSubscriber(clientB, RaceCategory.HORSE);

        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.HORSE);

        verify(clientA, times(3)).receive(horseMessage);
        verify(clientB, times(3)).receive(horseMessage);
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
    public void eachMessageShouldBeLogged() throws Exception {
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        Date date3 = mock(Date.class);
        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(date1).thenReturn(date2).thenReturn(date3);

        raceResults.send(horseMessage, RaceCategory.HORSE);
        raceResults.send(horseMessage, RaceCategory.F1);
        raceResults.send(f1Message, RaceCategory.BOAT);

        verify(logger).log(date1, horseMessage);
        verify(logger).log(date2, horseMessage);
        verify(logger).log(date3, f1Message);
    }

    @Test(expected = NoSuchElementException.class)
    public void testUnsubscribeWithoutSubscription() {
        raceResults.addSubscriber(clientB, RaceCategory.BOAT);
        raceResults.removeSubscriber(clientA, RaceCategory.BOAT);
    }
}
