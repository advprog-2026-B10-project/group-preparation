package id.ac.ui.cs.advprog.bidmart.wallet.controller;

import id.ac.ui.cs.advprog.bidmart.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/topup")
    public String topUp(@RequestParam String userId,
                        @RequestParam Double amount) {
        walletService.topUp(userId, amount);
        return "Top up successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String userId,
                           @RequestParam Double amount) {
        walletService.withdraw(userId, amount);
        return "Withdraw successful";
    }
}