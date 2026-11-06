package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {

    private MangaRecordClass manga1;
    private MangaRecordClass manga2;
    @BeforeEach
    public void setUp() {
        manga1 = new MangaRecordClass("Kimetsu no Yaiba", 24);
        manga2 = new MangaRecordClass("Kimetsu no Yaiba", 24);
    }

    @Test
    public void accessors_ReturnData_WhenInitialized() {
        Assertions.assertEquals("Kimetsu no Yaiba", manga1.name());
        Assertions.assertEquals(24, manga1.episodes()); // voce nao usa getters para pegar o atributo do Manga
    }

    @Test
    public void equals_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    public void hashCode_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }
}