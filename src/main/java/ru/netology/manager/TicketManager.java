package ru.netology.manager;

import ru.netology.data.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }
    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (from.equals(ticket.getFromAirport())) {
                if (to.equals(ticket.getToAirport())) {
                    Ticket[] tmp = new Ticket[tickets.length +1];
                    for (int i = 0; i < tickets.length; i++) {
                        tmp[i] = tickets[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    tickets = tmp;
                }
            }
        }
        Arrays.sort(tickets);
        return tickets;
    }

//    public Ticket[] searchBy(String text) {
//        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
//        for (Ticket ticket : repo.findAll()) {
//            if (ticket.matches(ticket, text)) {
//                Ticket[] tmp = new Ticket[result.length + 1];     //временный массив
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];                             //копируем массив
//
//                }
//                tmp[tmp.length - 1] = ticket;                      //добавляем
//                result = tmp;
//
//                // "добавляем в конец" массива result продукт product
//            }
//
//        }
//        return result;
//    }
}
