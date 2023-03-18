package com.tanmaymone.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car,Long> {
	//Fetch Cars by Brand
	List<Car> findByBrand(@Param ("brand") String brand);
	//Fetch Cars by Color
	List<Car> findByColor(@Param ("color") String color);
	//Fetch Cars by Year
	List<Car> findByYear (@Param ("year") int year);
	//Fetch Cars by Brand and Model
	List<Car> findByBrandAndModel (String brand, String model);
	//Fetch Cars by Brand or Color
	List<Car> findByBrandOrColor (String brand, String color);
	//Find Cars by Brand and Sort by Year
	List<Car> findByBrandOrderByYearAsc (String brand); //, int year);
	//Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand =?1")
	List<Car> findByBrand2(String brand);
	//Fetch Cars by brand using SQL
	@Query (" select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith (String brand);
}

