package ru.netology.repository;

import ru.netology.data.Ticket;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;

import java.util.Arrays;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }

    public void save(Ticket ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException(ticket.getId());
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }

        }
        tickets = tmp;
    }
}
