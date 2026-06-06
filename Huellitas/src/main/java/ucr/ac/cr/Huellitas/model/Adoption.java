package ucr.ac.cr.Huellitas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Adoption() {
    }

    public Adoption(Integer id, LocalDate date, AdoptionStatus status, User user, Pet pet) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.user = user;
        this.pet = pet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AdoptionStatus getStatus() {
        return status;
    }

    public void setStatus(AdoptionStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}