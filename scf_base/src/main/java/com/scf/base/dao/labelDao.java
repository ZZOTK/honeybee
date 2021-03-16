package com.scf.base.dao;

import com.scf.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface labelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
