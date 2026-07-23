package org.example.btth_ss11.models.services;

import org.example.btth_ss11.models.entities.Transfer;

public interface ITransferService {

    Transfer precessWithdrawal(Long accountId, Double amount);

}
