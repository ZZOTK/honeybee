package com.scf.base.service;

import com.scf.base.dao.labelDao;
import com.scf.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private labelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findall(){
        return labelDao.findAll();
    }

    public Label findById(String Id){
        return labelDao.findById(Id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String Id){
        labelDao.deleteById(Id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，条件封装到哪个对象。
             * @param criteriaQuery 封装的都是查询关键字 基本不用
             * @param criteriaBuilder 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    //相当于 where labelname like % label.getLabelname() %
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    //相当于 where labelname like % label.getLabelname() %
                    Predicate predicate = criteriaBuilder.like(root.get("state").as(String.class),  label.getState());
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        });
    }

    //分页查询
    public Page<Label> pageQuery(Label label, int page, int size) {
        //Pageable接口通过实现类
        Pageable pageable = PageRequest.of(page - 1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，条件封装到哪个对象。
             * @param criteriaQuery 封装的都是查询关键字 基本不用
             * @param criteriaBuilder 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    //相当于 where labelname like % label.getLabelname() %
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    //相当于 where labelname like % label.getLabelname() %
                    Predicate predicate = criteriaBuilder.like(root.get("state").as(String.class),  label.getState());
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        }, pageable);
    }
}
