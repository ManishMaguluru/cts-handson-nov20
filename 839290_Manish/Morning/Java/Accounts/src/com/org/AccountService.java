package com.org;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AccountService extends Account{
	
	Set<Account> accounts = new TreeSet<Account>((a1,a2) -> Integer.compare(a1.getAccNo(), a2.getAccNo()));
	
	
	public Account addAccount (Account account) throws AccountAlreadyExistsException{
		Account acc = new Account();
		for(Account account1 : accounts) {
			if(account1.getAccNo() == account.getAccNo())			
				throw new AccountAlreadyExistsException();
				}
		accounts.add(account);
		return acc;
	}
	
	public Set<Account> fetchAccountsList() {
		Set<Account> tempList = new TreeSet<Account>((a1,a2) -> Integer.compare(a1.getAccNo(), a2.getAccNo()));
		for(Account account : accounts) {
			tempList.add(account);
		}
		return tempList;
	}
	
	public boolean RemoveAccount(int accNo) throws AccountNotFoundException{
		for(Account account : accounts) {
			if(account.getAccNo() == accNo) {
				accounts.remove(account);
				return true;
			}
		}
		throw new AccountNotFoundException();
	}
	
	public Set<Account> fetchAccountsList(int accNo) throws AccountNotFoundException {
		Set<Account> tempList = new TreeSet<Account>((a1,a2) -> Integer.compare(a1.getAccNo(), a2.getAccNo()));
		for(Account account : accounts) {
			if(account.getAccNo() == accNo)
			{
				tempList.add(account);
			}
		}
		if(tempList.isEmpty())
		{
			throw new AccountNotFoundException();
		}
		return tempList;
	}
	
	public Set<Account> fetchAccountsListbyBalance() {
		Set<Account> tempList = new TreeSet<Account>((a1,a2) -> Integer.compare(a1.getAccNo(), a2.getAccNo()));
		/*for(Account account : accounts) {
			if(account.getBalance() < 1000)
			{
				tempList.add(account);
			}
		}*/
		tempList  = accounts.stream().filter(item -> item.getAccNo()<1000).collect(Collectors.toSet());
		return tempList;
	}

}
