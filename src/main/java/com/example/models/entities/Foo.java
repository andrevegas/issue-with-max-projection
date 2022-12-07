package com.example.models.entities;

import com.example.models.FooId;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Introspected
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "foo")
public class Foo implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    public FooId id;

    @Column(name = "qux")
    public int qux;
}
