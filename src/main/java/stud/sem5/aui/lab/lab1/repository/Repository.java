package stud.sem5.aui.lab.lab1.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<E, K> {

    Optional<E> find(K key);
    List<E> findAll();
    void create(E entity);
    void delete(K key);

}
