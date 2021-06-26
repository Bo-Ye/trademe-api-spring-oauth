package com.boye.trademe.service.impl;

import com.boye.trademe.service.TrademeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrademeServiceImpl implements TrademeService {

  private static final String WATCHLIST_URL = "https://api.tmsandbox.co.nz/v1/MyTradeMe/Watchlist/All.xml";

  @Autowired
  private OAuthRestTemplate oAuthRestTemplate;

  @Override
  public String getWatchlist() {
    return oAuthRestTemplate.getForObject(WATCHLIST_URL, String.class);
  }
}
