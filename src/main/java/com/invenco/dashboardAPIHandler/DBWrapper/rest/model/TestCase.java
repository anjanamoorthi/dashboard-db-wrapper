/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table( name = "testcase",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"module", "test_name"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase implements Serializable {

//    Commenting this for now. Later will add uuid as the unique id to identify test cases
//    @Id
//    @GeneratedValue(generator = "hibernate-uuid")
//    @GenericGenerator(name="hibernate-uuid", strategy = "uuid2")
//    @Column(name = "test_id", columnDefinition = "BINARY(16)")
//    private UUID uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    @NotNull
    @Column( name = "test_name", length = 100)
    private String name;

    @NotNull
    @Column ( name = "module", length = 50)
    private String module;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "importance_id", referencedColumnName = "importance_id", insertable = true, updatable = true)
    private Importance importance;

    @Column ( name = "testplan")
    private String testplan;

    @Column ( name = "ktf")
    private boolean ktf;

    @Column ( name = "skip")
    private boolean skip;

    @Column ( name = "requirement")
    private String requirement;

    @Column ( name = "duration")
    private Integer duration;

}
