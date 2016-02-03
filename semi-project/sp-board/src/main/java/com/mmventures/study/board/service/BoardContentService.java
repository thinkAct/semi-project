package com.mmventures.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmventures.study.board.dao.BoardContentDao;
import com.mmventures.study.core.domain.BoardContent;
import com.mmventures.study.core.domain.CommonField;

@Service("boardContentService")
@Transactional
public class BoardContentService {
    @Autowired
    private BoardContentDao boardContentDao;
    
    public BoardContentService() {
	
    }
    
    public void writeBoardContent() {
	BoardContent bc = new BoardContent();
	bc.setContent("TEST CONTENT");
	bc.setCommonField(new CommonField());
	
	boardContentDao.insertBoardContent(bc);
	
    }
    

}
