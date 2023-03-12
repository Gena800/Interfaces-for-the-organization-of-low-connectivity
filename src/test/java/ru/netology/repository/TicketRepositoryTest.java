package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket one = new Ticket(1, 600, "LED", "FRU", 500);
    Ticket two = new Ticket(2, 500, "OGZ", "FRU", 500);
    Ticket three = new Ticket(3, 300, "OGZ", "FRU", 500);
    Ticket four = new Ticket(4, 100, "LED", "OGZ", 500);
    Ticket five = new Ticket(5, 400, "LED", "FRU", 500);
    Ticket six = new Ticket(5, 400, "LED", "FRU", 500);

    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
    }

    @Test
    public void testSorting() {

        Ticket[] expected = {four, three, five, two, one};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdIfIdNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(20);
        });
    }


    @Test
    public void shouldFindById() {
        Ticket[] expected = {four};
        Ticket actual = repository.findById(4);
    }

    @Test

    public void setUpIfIdIsBusy() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.save(six);
        });
    }

}

