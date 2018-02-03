package com.practicalunittesting.c5.c7.c2;

import java.util.*;

public class RaceResultsService {

    private Map<RaceCategory, Collection<Client>> clientsMap = new HashMap<>();
    private Logger logger;

    public RaceResultsService(Logger logger) {
        this.logger = logger;
    }

    public void addSubscriber(Client client, RaceCategory raceCategory) {
        Collection<Client> clients = clientsMap.computeIfAbsent(raceCategory, k -> new HashSet<>());
        clients.add(client);
    }

    public void send(Message message, RaceCategory raceCategory) {
        logger.log(new Date(), message);

        Collection<Client> clients = clientsMap.get(raceCategory);
        if (clients == null) {
            return;
        }

        for (Client client: clients) {
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client, RaceCategory raceCategory) {
        Collection<Client> clients = clientsMap.get(raceCategory);
        if (clients == null) {
            return;
        }

        clients.remove(client);
    }
}
