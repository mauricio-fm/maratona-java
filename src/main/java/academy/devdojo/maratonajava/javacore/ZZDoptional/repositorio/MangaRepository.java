package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    // List.of cria uma lista que nao pode ser modificada, ja new ArrayList<>(), so pode acessar
    private static List<Manga> mangas = List.of(new Manga(1, "Dragon Ball", 347), new Manga(2, "Jujutsu Kaisen", 257));

    public static Optional<Manga> findById(Integer id) {
        return findBy(m -> m.getId().equals(id));
    }

    public static Optional<Manga> findByTitle(String title) {
        return findBy(m -> m.getTitle().equals(title)); // o titulo desse manga e igual ao titulo que estou procurando
    }

    private static Optional<Manga> findBy(Predicate<Manga> predicate) { // Predicate<Manga> predicate recebe um Manga e retorna true ou false
        Manga found = null;
        for (Manga manga : mangas) {
            if (predicate.test(manga)) { // Execute a condição armazenada em predicate, usando este manga
                found = manga; // guarda manga encontrado
            }
        }
        return Optional.ofNullable(found); //retorna Optional com o Manga ou Optional.empty() se for null

    }
}

