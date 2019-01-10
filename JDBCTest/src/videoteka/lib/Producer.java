package videoteka.lib;

import java.time.LocalDate;

public class Producer {
    private String name;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Producer(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
