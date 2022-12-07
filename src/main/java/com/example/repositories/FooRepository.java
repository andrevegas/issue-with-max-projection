package com.example.repositories;

import com.example.models.FooId;
import com.example.models.entities.Foo;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.GenericRepository;

import java.util.Optional;

@Repository
public interface FooRepository extends GenericRepository<Foo, FooId> {

    //This max query projection works fine
    Optional<Number> getMaxQuxByIdBaz(int baz, int qux);

    //This max query projection using one of the Embeddable fields doesn't work
    Optional<Number> getMaxIdBarByQux(int qux);

    //This is the expected query for the `getMaxIdBarByQux` query projection that fails.
    @Query(value = " SELECT MAX(foo_.id.bar) FROM Foo AS foo_ WHERE (foo_.qux = :qux)")
    Optional<Number> getMaxIdBarByQux1(int qux);

}
