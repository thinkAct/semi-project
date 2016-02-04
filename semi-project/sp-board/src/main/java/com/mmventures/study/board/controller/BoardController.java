package com.mmventures.study.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmventures.study.board.service.BoardContentService;
import com.mmventures.study.board.service.BoardInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageSource messageSource;
	
	
	
    /** BoardContent service. */
    @Autowired
    private BoardContentService boardContentService;
    /** Board service. */
    @Autowired
    private BoardInfoService boardService;

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(BoardController.class);
        
    /**
     * 임시 테스트용.
     * 
     * @param locale
     *            Locale
     * @param model
     *            dataModel
     * @return jsp url
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String home(final Locale locale, final Model model) {
	LOGGER.info("Welcome home! The client locale is {}.", locale);

	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		DateFormat.LONG, locale);

	String formattedDate = dateFormat.format(date);

	model.addAttribute("serverTime", formattedDate);

	return "home";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception{
		Locale locale = LocaleContextHolder.getLocale();
		String testmsg1 = messageSource.getMessage("AbstractLdapAuthenticationProvider.badCredentials", null, "시큐리티 디폴트 메시지", Locale.KOREA);
		String testmsg2 = messageSource.getMessage("TestKey.testParam", null, "디폴트 메시지", Locale.KOREA);
		
		logger.debug("testmsg1 : {}", testmsg1);
		logger.debug("testmsg2 : {}", testmsg2);
		return "login";
	}

    /**
     * Hibernate test.
     * 
     * @param model
     *            model
     * @return view
     */
    @RequestMapping(value = "/ht", method = RequestMethod.GET)
    public final String hibernateTest(final Model model) {
	LOGGER.debug("HibernateTEst DEBUG LOG.");
	LOGGER.info("HibernateTest INFO LOG.");
	
	boardContentService.writeBoardContent();

	return "test";
    }
    
    /**
     * Hibernate test.
     * 
     * @param model
     *            model
     * @return view
     */
    @RequestMapping(value = "/ht2", method = RequestMethod.GET)
    public final String hibernateTest2(final Model model) {
	boardService.createBoardInfo();

	return "test";
    }
    
    

}
