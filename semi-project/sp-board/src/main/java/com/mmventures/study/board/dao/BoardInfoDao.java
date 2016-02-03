package com.mmventures.study.board.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmventures.study.core.domain.BoardContent;
import com.mmventures.study.core.domain.BoardInfo;

/**
 * Board Info DAO.
 * 
 * @author Jihwan
 *
 */
@Repository("boardInfoDao")
public class BoardInfoDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * DefaultConstructor.
     */
    public BoardInfoDao() {
	
    }
    
    public void insertBoardInfo(BoardInfo boardInfo) {
	Session session = sessionFactory.openSession();
	session.save(boardInfo);
	session.close();
    }
    
    
}
