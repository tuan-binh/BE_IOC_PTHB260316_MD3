package org.example.btth_ss11.models.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.btth_ss11.exceptions.InsufficientBalanceException;
import org.example.btth_ss11.exceptions.NotFoundException;
import org.example.btth_ss11.models.constants.TransferType;
import org.example.btth_ss11.models.entities.Account;
import org.example.btth_ss11.models.entities.Transfer;
import org.example.btth_ss11.models.repositories.IAccountRepository;
import org.example.btth_ss11.models.repositories.ITransferRepository;
import org.example.btth_ss11.models.services.ITransferService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements ITransferService {
    private final ITransferRepository transferRepository;
    private final IAccountRepository accountRepository;

    @Override
    public Transfer precessWithdrawal(Long accountId, Double amount) {
        log.info("precessWithdrawal gồm tài khoản người dùng {} muốn rút tiền là {}", accountId, amount);
        // 1. người dùng có tồn tại hay không
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException("Account not found"));
        log.debug("Account info = {}", account);
        // 2. kiểm tra số dư
        log.debug("Số dự hiện có = {} và số tiền muốn chuyển là = {}",account.getBalance(),account);
        if(account.getBalance() < amount) {
            throw new InsufficientBalanceException("Account balance too low");
        }

        // 3. trừ tiền người dùng và lưu vào db
        log.debug("Số tiền trước khi rút = {}",account.getBalance());
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        log.debug("Số tiền sau khi rút = {}",account.getBalance());


        // 4. thêm lượt giao dịnh vào transfer
        Transfer transfer = Transfer.builder()
                .type(TransferType.WITHDRAW)
                .amount(amount)
                .account(account)
                .build();
        transfer = transferRepository.save(transfer);
        log.debug("Saved Transfer = {}", transfer);

        return transfer;
    }
}
