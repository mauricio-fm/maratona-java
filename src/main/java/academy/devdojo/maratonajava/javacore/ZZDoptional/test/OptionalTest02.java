package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Dragon Ball");
        mangaByTitle.ifPresent(m -> m.setTitle("Dragon Ball Z"));
        System.out.println(mangaByTitle);
        //  resumindo, "Linha 10" -> procura por titulo o manga "Dragon Ball Broly",
        // "Linha 11" -> se achar muda o titulo para "Dragon Ball Z Broly"

        Manga mangaById = MangaRepository.findById(2)
                .orElseThrow(IllegalArgumentException::new);// procura manga por id, se nao achar lanca uma excecao
        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTitle("Dr.Stone")
                .orElse(new Manga(3, "Dr.Stone", 95)); // procura o manga Dr.Stone, se nao existir cria ele
        System.out.println(newManga);
    }
}
