package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio;

public class Person {
    private String fisrtName;
    private String lastName;
    private String username;
    private String email;

    private Person(String fisrtName, String lastName, String username, String email) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public static final class PersonBuilder {
        private String fisrtName;
        private String lastName;
        private String username;
        private String email;

        private PersonBuilder() {
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public PersonBuilder fisrtName(String fisrtName) {
            this.fisrtName = fisrtName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(fisrtName, lastName, username, email);
        }
    }


    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }
}
