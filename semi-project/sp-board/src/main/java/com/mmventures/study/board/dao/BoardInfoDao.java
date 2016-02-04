package com.mmventures.study.board.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
