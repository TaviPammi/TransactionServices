package com.apiservices.rest;

import javax.ws.rs.core.*;

import com.apiservices.Transaction;
import com.sun.jersey.spi.resource.Singleton;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;

@Singleton
@Path("/transactionservice")
public class TransactionService {
	
	private List<Transaction> transactionList = new ArrayList<Transaction>();
	
	@Path("/transaction/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newTransaction(@PathParam("id") long transactionId, Transaction transaction) {
		transaction.setTransaction_id(transactionId);
		transactionList.add(transaction);
		String result = "Transaction saved : " + transaction;
		return Response.status(201).entity(result).build();
	}
	
	
	@GET
	@Path("/transaction/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction getTransactionsById(@PathParam("id") long transactionId) {
		Transaction matchedTransaction = null;
		for(Transaction transaction : transactionList) {
			if(transaction.getTransaction_id() == transactionId) {
				matchedTransaction = transaction;
			}
		}
		return matchedTransaction;
	}
	
	@GET
	@Path("/types/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getTransactionsByType(@PathParam("type") String type) {
		List<Transaction> allMatchedTransactions = new ArrayList<Transaction>();
		for(Transaction transaction : transactionList) {
			if(type.equalsIgnoreCase(transaction.getType())) {
				allMatchedTransactions.add(transaction);
			}
		}
		return allMatchedTransactions;
	}

	@GET
	@Path("/sum/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sumTransactions(@PathParam("id") long transactionId) {
		double response = 0;
		String result = "";
		
		for(Transaction transaction : transactionList) {
			if(transactionId == transaction.getTransaction_id()) {
				response = response + transaction.getAmount();
			}
			
			if(transactionId == transaction.getParent_id()) {
				response = response + transaction.getAmount();
			}
		}
		result = "{\"sum\": " + response + "}";
		return Response.status(200).entity(result).build();
	}
}
