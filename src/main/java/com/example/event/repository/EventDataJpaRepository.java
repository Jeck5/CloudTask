package com.example.event.repository;

import com.example.event.model.Event;
import com.example.event.to.EventSsoidFormid;
import com.example.event.to.EventSsoidSubtype;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventDataJpaRepository extends CrudRepository<Event,Long>, JpaSpecificationExecutor<Event> {

    @Query(value = "SELECT formid, ssoid FROM event WHERE formid <>'' AND datetime >= :ts", nativeQuery = true)
    List<EventSsoidFormid> getUsersAndForms(@Param("ts") Timestamp ts);

    @Query(value = "SELECT t.ssoid,t.subtype FROM ( SELECT ssoid,max(datetime) AS maxtime FROM event GROUP BY ssoid) r \n" +
            "INNER JOIN event t ON t.ssoid = r.ssoid AND t.datetime = r.maxtime  WHERE (t.subtype <> 'send' AND t.subtype<>'success')\n",
             nativeQuery = true)
    List<EventSsoidSubtype> getUsersNotFinshed();


    @Query(value = "select n1.formid from (select formid,count(*) as a1 from event group by formid order by a1 desc limit :num) n1 where n1.formid <>''", nativeQuery = true)
    List<String> getForms(@Param("num") int num);

}
