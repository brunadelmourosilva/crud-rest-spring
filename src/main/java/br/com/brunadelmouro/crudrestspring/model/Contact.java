package br.com.brunadelmouro.crudrestspring.model;

/* using Lombok */
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/* JPA */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor /* automatically creates a constructor with all class attributes as an argument */
@NoArgsConstructor /* automatically creates a void constructor(no arguments) */
@Data /* toString, equals, hashCode, getters and setters */
@Entity /* JPA will establish the link between the entity and a table of the same name in the database */

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private  String phone;


}
