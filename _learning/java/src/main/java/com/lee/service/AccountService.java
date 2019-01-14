/**
 * $\Id$
 * User: chealwoo
 * Date: Apr 7, 2010
 * Time: 9:35:41 AM
 * Copyright (c) Chealwoo Lee (Daniel) 2010, All rights reserved.
 */
package com.lee.service;


import com.lee.model.user.Account;
import com.lee.service.exception.CwlServiceException;

import java.util.List;

public interface AccountService {

   public List<Account> getAllAccounts() throws CwlServiceException;
   public Account getAccountById(Long id) throws CwlServiceException;
   public Account saveAccount(Account a) throws CwlServiceException;
   public Account createAccount(Account a) throws CwlServiceException;
   public void deleteAccount(Long id) throws CwlServiceException;
}
