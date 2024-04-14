package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCalendar;
    LocalDate startDate;
    LocalDate endDate;

    @OneToOne(mappedBy = "calendarUser")
    User userCalendar;

}
