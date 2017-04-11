package by.intexsoft.picturegallery.repository;

import by.intexsoft.picturegallery.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface for {@link JpaRepository}
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    /**
     * Custom method to find authority by name
     * @param name
     * @return {@link Authority}
     */
    Authority findByName(@Param("name") String name);
}
