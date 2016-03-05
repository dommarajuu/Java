package com.zensar.bankingsystem.dao;

import com.zensar.bankingsystem.beans.Account;
import com.zensar.bankingsystem.beans.Customer;
import com.zensar.bankingsystem.beans.Transaction;

public class ZensarBankingSystemArrayImpl implements BankingRepositoryServices {

	Customer[] customers = new Customer[10];

	static int i = 0, j = 0, custId = 100, accId = 50;

	@Override
	public int insertCustomer(Customer customer) {
		customers[i++] = customer;
		customer.setCustomerId(custId);
		custId++;
		return customer.getCustomerId();
	}

	@Override
	public Customer getCustomer(int custId) {
		for (Customer c : customers) {
			if (c != null && c.getCustomerId() == custId)
				return c;
		}
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTransaction(int custId, int accNo,
			Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccount(int custId, int accNo) {

		Account[] acc = getCustomer(custId).getAccount();
		for (int k = 0; k < 3; k++) {
			if (acc[k].getAccountId() == accNo)
				return acc[k];
			else
				return null;
		}
		return null;
	}

	@Override
	public Account[] getAccountList(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction[] getTransactions(int custId, int accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int custId, int accNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertAccount(Account account, int custId) {
		Account[] acc = getCustomer(custId).getAccount();

		for (int k = 0; k < 3; k++) {

			if (acc[k] == null) {
				acc[k] = new Account(accId++, account.getAccountType(),
						account.getBalance());
				return acc[k].getAccountId();
			}
		}
		return 0;
	}

	@Override
	public boolean updateAccount(int custId, Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
