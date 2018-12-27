package com.zhaluobox.crazyjava.souceCode.springdata;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@SuppressWarnings("all")
public interface JpaRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {


    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    List<T> findAll();

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
     */
    List<T> findAll(Sort sort);

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
     */
    List<T> findAll(Iterable<ID> ids);

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
     */
    <S extends T> List<S> save(Iterable<S> entities);

    /**
     * Flushes all pending changes to the database.
     */
    void flush();

    /**
     * Saves an entity and flushes changes instantly.
     *
     * @param entity
     * @return the saved entity
     */
    <S extends T> S saveAndFlush(S entity);

    /**
     * Deletes the given entities in a batch which means it will create a single
     *
     * the {@link javax.persistence.EntityManager} after the call.
     *
     * @param entities
     */
    void deleteInBatch(Iterable<T> entities);

    /**
     * Deletes all entities in a batch call.
     */
    void deleteAllInBatch();

    /**
     * Returns a reference to the entity with the given identifier.
     *
     * @param id must not be {@literal null}.
     * @return a reference to the entity with the given identifier.
     * @see EntityManager#getReference(Class, Object)
     */
    T getOne(ID id);

    /* (non-Javadoc)
     * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example)
     */
    @Override
    <S extends T> List<S> findAll(Example<S> example);

    /* (non-Javadoc)
     * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
     */
    @Override
    <S extends T> List<S> findAll(Example<S> example, Sort sort);



}
