package ro.gameon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bogdan on 1/29/14.
 */
public abstract class GenericDao {

    @PersistenceContext(unitName = "persistenceUnit")
    protected EntityManager entityManager;

    public <T> void persist(T entity) {
        entityManager.persist(entity);
    }

    public <T> void persistCollection(Collection<T> entities) {
        for (T entity : entities) {
            persist(entity);
        }
    }

    public <T> T merge(T entity) {
        return entityManager.merge(entity);
    }

    public <T> Collection<T> mergeCollection(Collection<T> entities) {
        Collection<T> mergedResults = new ArrayList<T>(entities.size());
        for (T entity : entities) {
            mergedResults.add(merge(entity));
        }
        return mergedResults;
    }

    public <T, PK extends Serializable> void removeByPK(PK id, Class<T> clazz) {
        Object ref = entityManager.find(clazz, id);
        remove(ref);
    }

    public <T> void remove(T entity) {
        entityManager.remove(entity);
    }

    public <T> void removeCollection(Collection<T> entities) {
        for (T entity : entities) {
            remove(entity);
        }
    }

    public <T, PK extends Serializable> T findById(PK id, Class<T> clazz) {
        return entityManager.find(clazz, id);
    }

    public void flush() {
        entityManager.flush();
    }

    protected <V> List<V> executeQuery(String jpql, Class<V> clazz, Object... parameters) {
        TypedQuery<V> query = entityManager.createQuery(jpql, clazz);
        addQueryParameters(query, parameters);
        return query.getResultList();
    }

    protected <V> V executeSingleResultQuery(String jpql, Class<V> clazz, Object... parameters) {
        TypedQuery<V> query = entityManager.createQuery(jpql, clazz);
        addQueryParameters(query, parameters);
        return query.getSingleResult();
    }

    protected void executeUpdateQuery(String jpql, Object... parameters) {
        Query query = entityManager.createQuery(jpql);
        addQueryParameters(query, parameters);
        query.executeUpdate();
    }

    private void addQueryParameters(Query query, Object[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            query.setParameter(i + 1, parameters[i]);
        }
    }
}
