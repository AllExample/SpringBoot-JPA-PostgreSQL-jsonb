package com.meike.station.common.modle.jsonb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JSONBRepository extends JpaRepository <JSONBEntity, Long>{



}
