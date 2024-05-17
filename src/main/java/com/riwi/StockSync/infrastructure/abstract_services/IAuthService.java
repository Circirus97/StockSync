package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.LoginReq;
import com.riwi.StockSync.api.dto.request.RegisterReq;
import com.riwi.StockSync.api.dto.response.AuthResp;

public interface IAuthService {
    
    public AuthResp login(LoginReq request);
    
    public AuthResp register(RegisterReq request);

    public AuthResp registerEmployee(EmployeeRegisterReq request);
}