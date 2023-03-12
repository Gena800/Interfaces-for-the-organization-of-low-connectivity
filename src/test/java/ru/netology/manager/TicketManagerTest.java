package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.TimeTravelComparator;
import ru.netology.data.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {


    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TimeTravelComparator timeTravelComparator = new TimeTravelComparator();
    Ticket one = new Ticket(1, 600, "LED", "FRU", 100);
    Ticket two = new Ticket(2, 500, "OGZ", "FRU", 200);
    Ticket three = new Ticket(3, 300, "OGZ", "FRU", 300);
    Ticket four = new Ticket(4, 100, "LED", "OGZ", 400);
    Ticket five = new Ticket(5, 400, "LED", "FRU", 500);
    Ticket six = new Ticket(6, 6_000, "LED", "FRU", 600);
    Ticket seven = new Ticket(7, 5_000, "OGZ", "FRU", 700);
    Ticket eight = new Ticket(8, 3_000, "OGZ", "FRU", 800);
    Ticket nine = new Ticket(9, 1_000, "LED", "OGZ", 900);
    Ticket ten = new Ticket(10, 4_000, "LED", "FRU", 1_000);


    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
    }


    @Test

    public void shouldFindTickets() {

        Ticket[] expected = {five, one, ten, six};
        Ticket[] actual = manager.findAll("LED", "FRU");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "LED");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldNotFindTicketsByTravelTime() {

        Ticket[] expected = {one, five, six, ten};
        Ticket[] actual = manager.findAll("LED", "FRU", timeTravelComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

}