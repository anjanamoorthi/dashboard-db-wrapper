package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.invenco.dashboardAPIHandler.DBWrapper.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true) // Required if we are extending BaseClass
public class TestResult extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "release_id", referencedColumnName = "release_id", insertable = true, updatable = true)
	private Releases release;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id", referencedColumnName = "test_id", insertable = true, updatable = true)
	private TestCase testcase_name;

	private String test_module;
	
	private int test_duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_status_id", referencedColumnName = "test_status_id", insertable = true, updatable = true)
	private TestStatus status;
	
	private String test_starttime;
	private String test_finishtime;
	
	private String product;
	private String note;

}
