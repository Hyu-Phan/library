package com.elcom.library.repository.lib;

import com.elcom.library.entity.lib.Category;
import com.elcom.library.dto.CategoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select c.name as category, count(b.id) as numOfBook " +
            "from category c " +
            "left outer join book b " +
            "on c.id = b.cate_id " +
            "group by c.name", nativeQuery = true)
    List<CategoryCustom> findNumOfBook();
}
