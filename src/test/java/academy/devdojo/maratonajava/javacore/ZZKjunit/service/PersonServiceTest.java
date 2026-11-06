package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// TODO um bom teste deve testar todos os casos possiveis, aqui por exemplo deve testar, >18, <18, ==18, <0, >100 e null
class PersonServiceTest {

    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach
    public void setUp() { // esse metodo e execultado antes de cada um dos testes unitarios
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
        // o retorno depende do metodo que esta sendo testado, nem sempre e
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() { // retorna falso quando a idade e menor que 18
        Assertions.assertFalse(personService.isAdult(notAdult)); // verifica se o metodo retornou false, espera que uma
        // pessoa de 15 anos nao seje considerada adulta
        // se retorna true o teste falhou
        // test passed funcionou test failed nao funcionou
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.isAdult(null), "Person can't be null");
        // gera uma NullPointerException quando isAdult e null, nesse caso true pois passamos o person como null
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> personList = List.of(person1, person2, person3);
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }


    /**
     * cada assert tem parametros diferentes
     *
     * Assertion	                                    Parâmetros
     * assertEquals(expected, actual)	                Esperado, obtido
     * assertNotEquals(unexpected, actual)	            Não esperado, obtido
     * assertTrue(condition)	                        Condição
     * assertFalse(condition)	                        Condição
     * assertNull(actual)	                            Valor que deve ser null
     * assertNotNull(actual)	                        Valor que não deve ser null
     * assertThrows(Exception.class, executable)	    Exceção esperada, código executado
     */
}