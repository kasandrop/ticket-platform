package com.sellermicroservice;

public interface ListingRepository {
}
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}