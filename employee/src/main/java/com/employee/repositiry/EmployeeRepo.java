package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	 @Query("SELECT COUNT(e) FROM Employee e WHERE e.gender = 'male'")
	    long countMaleEmployees();

	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.gender = 'female'")
	    long countFemaleEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.gender = 'trans'")
	    long countTransEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'Current'")
	    long countCurrentEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'Ex-Employee'")
	    long countExEmployeeEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'New Joining'")
	    long countNewjoiningEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'Transferred In'")
	    long countTransferredInEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'Transferred Out'")
	    long countTransferredOutEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.status = 'Exited Employee'")
	    long countExitedEmployeeEmployees();
	    
	    
	
	

}
