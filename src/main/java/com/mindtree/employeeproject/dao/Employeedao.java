package com.mindtree.employeeproject.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.employeeproject.entity.Employe;

public interface Employeedao extends JpaRepository<Employe, Integer> {

	@Query("from Employe where salary=?1 order by name")
	List<Employe> findBySalarySorted(long salary);

	

}
