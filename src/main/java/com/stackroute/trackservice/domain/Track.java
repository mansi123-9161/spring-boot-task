package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private int _id;
    private String name;
    private String comments;

}
