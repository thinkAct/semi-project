package com.mmventures.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmventures.study.board.dao.BoardInfoDao;
import com.mmventures.study.core.domain.BoardInfo;
import com.mmventures.study.core.domain.CommonField;

@Service("boardInfoService")
public class BoardInfoService {
    @Autowired
    private BoardInfoDao boardInfoDao;
    
    public BoardInfoService() {
	
    }
    
    public void createBoardInfo() {
	BoardInfo boardInfo = new BoardInfo();
	boardInfo.setTitle("TEST BOARD");
	boardInfo.setCommonField(new CommonField());
	
	boardInfoDao.insertBoardInfo(boardInfo);
    }
    

}
