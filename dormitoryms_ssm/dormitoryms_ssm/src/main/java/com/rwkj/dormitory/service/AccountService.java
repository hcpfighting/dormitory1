package com.rwkj.dormitory.service;

import com.rwkj.dormitory.dto.AccountDto;
import com.rwkj.dormitory.form.AccountForm;

public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
