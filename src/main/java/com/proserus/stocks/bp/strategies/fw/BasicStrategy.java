package com.proserus.stocks.bp.strategies.fw;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proserus.stocks.bo.analysis.Analysis;
import com.proserus.stocks.bo.transactions.Transaction;
import com.proserus.stocks.bp.model.Filter;

public abstract class BasicStrategy<T> implements SymbolStrategy<T> {
	protected static Logger calculsLog = LoggerFactory.getLogger("calculs." + BasicStrategy.class.getName());

	@Override
	abstract public void process(Analysis analysis, Collection<Transaction> transactions, Filter filter);

	public abstract T getTransactionValue(Transaction t, Filter filter);

	public abstract void setAnalysisValue(Analysis analysis, T value);

	@Override
	abstract public T getDefaultAnalysisValue();
}
