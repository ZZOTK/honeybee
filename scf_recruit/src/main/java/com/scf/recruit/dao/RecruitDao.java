package com.scf.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.scf.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	public List<Recruit> findTopByByStateOrderByCreatetimeDesc(String state);

	public List<Recruit> findTopByStateNotOrderByCreatetimeDesc(String state);
}
