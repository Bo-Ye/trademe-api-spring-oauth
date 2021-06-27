package com.boye.trademe.web;

import com.boye.trademe.service.TrademeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

  private static final Logger LOGGER = Logger.getLogger(WebController.class);

  @Autowired
  private TrademeService trademeService;

  static {
    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/watchlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public String getWatchlist() {
    String watchlist = trademeService.getWatchlist();
    LOGGER.info("Watchlist is: " + watchlist);
    return watchlist;
  }
}
