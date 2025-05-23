import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    public static Parser handle;

    @BeforeAll
    static void setUp() throws IOException {
        handle = new Parser();
        handle.setUp();
    }

    @Test
    public void testSortByName() {
        List<Game> sortedGames = handle.sortByName();
        Game g1 = new Game("Bloodborne" ,4.8,88);
        Game g2 = new Game("Gran Turismo 2" ,4.6,90);
        Game g3 = new Game("Resident Evil Code: Veronica" ,4.6,85);
        Game g4 = new Game("Super Smash Bros. Melee" ,4.8,91);
        Game g5 = new Game("The Last of Us" ,4.9,92);
        Game g6 = new Game("Wipeout XL" ,4.3,86);

        assertEquals(100, sortedGames.size());
        assertEquals(sortedGames.get(3),g1);
        assertEquals(sortedGames.get(31),g2);
        assertEquals(sortedGames.get(57),g3);
        assertEquals(sortedGames.get(72),g4);
        assertEquals(sortedGames.get(79),g5);
        assertEquals(sortedGames.get(98),g6);
    }

        @Test
        public void testSortByPrice() {
            List<Game> sortedGames = handle.sortByPrice();
            Game g1 = new Game("Tekken 3" ,4.4,91);
            Game g2 = new Game("The Legend of Zelda: The Wind Waker" ,4.8,90);
            Game g3 = new Game("Advance Wars" ,4.7,89);
            Game g4 = new Game("Company of Heroes" ,4.7,87);
            Game g5 = new Game("Uncharted 3: Drake's Deception" ,4.7,84);
            Game g6 = new Game("Final Fantasy XII" ,4.7,76);

            assertEquals(100, sortedGames.size());
            assertEquals(sortedGames.get(8),g1);
            assertEquals(sortedGames.get(14),g2);
            assertEquals(sortedGames.get(29),g3);
            assertEquals(sortedGames.get(44),g4);
            assertEquals(sortedGames.get(56),g5);
            assertEquals(sortedGames.get(82),g6);
        }

    @Test
    public void testSortByRating() {
        List<Game> sortedGames = handle.sortByRating();
        Game g1 = new Game("God of War II" ,4.9,90);
        Game g2 = new Game("Diablo" ,4.8,87);
        Game g3 = new Game("Advance Wars" ,4.7,89);
        Game g4 = new Game("Unreal Tournament 2004" ,4.6,88);
        Game g5 = new Game("Gran Turismo 3: A-Spec" ,4.5,84);
        Game g6 = new Game("Call of Duty: Infinite Warfare - Sabotage" ,4.3,18);

        assertEquals(100, sortedGames.size());
        assertEquals(sortedGames.get(5),g1);
        assertEquals(sortedGames.get(12),g2);
        assertEquals(sortedGames.get(29),g3);
        assertEquals(sortedGames.get(38),g4);
        assertEquals(sortedGames.get(45),g5);
        assertEquals(sortedGames.get(64),g6);
    }
}
