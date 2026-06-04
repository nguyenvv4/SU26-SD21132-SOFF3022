package com.example.sd21102.repo;

import com.example.sd21102.model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempRepo  extends JpaRepository<Temp, Integer> {

    @Query(value = """
                        select hoc_sinh.id, hoc_sinh.ho_ten, lop_hoc.ten_lop
                        from hoc_sinh inner join lop_hoc on hoc_sinh.lop_hoc_id = lop_hoc.id
            """,
    nativeQuery = true)
    public List<Temp> getAllTemp();
}
