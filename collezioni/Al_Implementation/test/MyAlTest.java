import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAlTest {

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo add")
    void add() {
        MyAl m = new MyAl();
        m.add(1);
        assertEquals(1, m.size());
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        assertEquals(10, m.size());
        assertTrue(m.add(4));
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo add in posizione")
    void addIndex() {
        MyAl m = new MyAl();
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        m.add(1, 4);
        assertEquals(m.get(4), 1);
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo size")
    void size() {
        MyAl m = new MyAl();
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        assertEquals(m.size(), 16);
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo get")
    void get() {
        MyAl m = new MyAl();
        m.add(13); m.add(34); m.add(43);
        assertEquals(m.get(2), 43);
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo clear")
    void clear() {
        MyAl m = new MyAl();
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3); m.add(3);
        m.clear();
        assertEquals(m.size(), 0);
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo contains")
    void contains() {
        MyAl m = new MyAl();
        m.add(13); m.add(34); m.add(43);
        assertTrue(m.contains(43));
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo isEmpty")
    void isEmpty() {
        MyAl m = new MyAl();
        m.add(1);
        assertFalse(m.isEmpty());
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo remove")
    void remove() {
        MyAl m = new MyAl();
        m.add(13); m.add(34); m.add(43);
        m.remove(2);
        assertFalse(m.contains(43));
    }

    @Test
    @DisplayName("Test per controllare il funzionamento del metodo indexOf")
    void indexOf() {
        MyAl m = new MyAl();
        m.add(13); m.add(34); m.add(43); m.add(13); m.add(34); m.add(43);
        assertEquals(m.indexOf(34), 1);
    }
}