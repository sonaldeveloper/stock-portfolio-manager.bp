package com.proserus.stocks.bp.strategies;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.proserus.stocks.bo.analysis.Analysis;

public class DividendYield extends AbstractAnalysisStrategy {
	protected static Logger calculsLog = Logger.getLogger("calculs." + DividendYield.class.getName());

	@Override
	protected void process(Analysis analysis) {
		double value = 0d;

		double divisor = analysis.getTotalCost().doubleValue() + analysis.getTotalSold().doubleValue() - analysis.getCapitalGain().doubleValue();

		if (calculsLog.isInfoEnabled()) {
			calculsLog.info("--------------------------------------");
			calculsLog.info("dividend yield = dividend / divisor");
			calculsLog.info("divisor = (getCurrentCost + getTotalSold - getCapitalGain)");
			calculsLog.info("getCurrentCost: " + analysis.getTotalCost());
			calculsLog.info("getTotalSold: " + analysis.getTotalSold());
			calculsLog.info("getCapitalGain: " + analysis.getCapitalGain());
			calculsLog.info("getDividend: " + analysis.getDividend());
			calculsLog.info("divisor: " + divisor);
		}

		// TODO use averageCostPerDay instead
		if (divisor > 0) {
			value = analysis.getDividend().doubleValue() * 100 / divisor;
			calculsLog.info("Calculated dividend yield successfully");
		} else {
			calculsLog.info("Failed to calculate dividend yield: divisor is not over 0");
		}

		calculsLog.info("setDividendYield = " + value);
		analysis.setDividendYield(new BigDecimal(value));
	}
}