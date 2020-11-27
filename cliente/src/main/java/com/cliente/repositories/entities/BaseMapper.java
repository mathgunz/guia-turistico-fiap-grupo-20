package com.cliente.repositories.entities;

public interface BaseMapper<E, S> {
     S toEntity(E entity);
}