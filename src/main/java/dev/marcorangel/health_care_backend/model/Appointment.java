package dev.marcorangel.health_care_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Appointment {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String booking_id = UUID.randomUUID().toString();
    private String disease;

    private Date tentativeDate;
    private String priority;

    private String patientId;
    private Date bookingTime;

    public Appointment( String disease, Date tentativeDate, String priority, String patientId) {
        super();

        this.disease = disease;
        this.tentativeDate = tentativeDate;
        this.priority = priority;
        this.patientId = patientId;

    }

    public Appointment() {
        super();
    }
}
