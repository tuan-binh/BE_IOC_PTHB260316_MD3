package org.example.demo_ss07.models.repositories;

import org.example.demo_ss07.models.dtos.req.SearchCourseDTO;
import org.example.demo_ss07.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

    @Query("""
        SELECT c FROM Course c
            WHERE (:title IS NULL OR c.title LIKE %:title%) AND
                (:minPrice IS NULL OR :maxPrice IS NULL) OR (c.price >= :minPrice AND c.price <= :maxPrice)
    """)
    List<Course> searchAdvanced(
            @Param("title") String title,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );

}
