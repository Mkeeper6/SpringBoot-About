package com.mkeeper.jpa;

import com.mkeeper.entity.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodInfoRepository
        extends JpaRepository<GoodInfoEntity,Long>
{
}