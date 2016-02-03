package com.mmventures.study.board.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmventures.study.core.domain.BoardContent;

/**
 * BoardContent dao.
 * 
 * @author Jihwan
 *
 */
@Repository("boardContentDao")
public class BoardContentDao {
    /** Session factory. */
    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Default constructor.
     */
    public BoardContentDao() {

    }
    
    /**
     * Insert content.
     * 
     * @param boardContent boardContent
     */
    public final void insertBoardContent(final BoardContent boardContent) {
	Session session = sessionFactory.openSession();
	session.save(boardContent);
	session.close();
    }

}
