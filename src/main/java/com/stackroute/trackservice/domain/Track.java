package com.stackroute.trackservice.domain;

import com.mongodb.client.model.Collation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.mapping.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Id;
import java.lang.annotation.Documented;

//@Entity annotation defines that a class can be mapped to a table.
//@Entity
@Document(collection = "track")
//@Data is like having implicit @Getter,
// @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class
@Data
//to generate no argument constructor
@NoArgsConstructor
//to generate all parameter argument constructor
@AllArgsConstructor
//@Builder lets you automatically produce the code required to have your class be instantiable with code
@Builder
public class Track {
    @Id
    private int id;
    private String name;
    private String comments;

}
