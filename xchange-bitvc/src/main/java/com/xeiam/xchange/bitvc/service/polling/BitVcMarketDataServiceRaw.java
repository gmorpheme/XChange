package com.xeiam.xchange.bitvc.service.polling;

import java.io.IOException;

import si.mazi.rescu.RestProxyFactory;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitvc.BitVc;
import com.xeiam.xchange.bitvc.dto.marketdata.BitVcDepth;
import com.xeiam.xchange.bitvc.dto.marketdata.BitVcOrderBookTAS;
import com.xeiam.xchange.bitvc.dto.marketdata.BitVcTicker;

public class BitVcMarketDataServiceRaw extends BitVcBasePollingService {

  private final BitVc bitvc;

  protected BitVcMarketDataServiceRaw(ExchangeSpecification exchangeSpecification) {

    super(exchangeSpecification);

    final String baseUrl = exchangeSpecification.getPlainTextUri();
    bitvc = RestProxyFactory.createProxy(BitVc.class, baseUrl);
  }

  public BitVcTicker getBitVcTicker(String symbol) throws IOException {

    return bitvc.getTicker(symbol);
  }

  public BitVcDepth getBitVcDepth(String symbol) throws IOException {

    return bitvc.getDepth(symbol);
  }

  public String[][] getBitVcKline(String symbol, String period) throws IOException {

    return bitvc.getKline(symbol, period);
  }

  public BitVcOrderBookTAS getBitVcDetail(String symbol) throws IOException {

    return bitvc.getDetail(symbol);
  }

}
