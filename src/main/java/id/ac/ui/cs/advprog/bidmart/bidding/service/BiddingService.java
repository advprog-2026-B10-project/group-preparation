package id.ac.ui.cs.advprog.bidmart.bidding.service;

import id.ac.ui.cs.advprog.bidmart.bidding.entity.Auction;
import id.ac.ui.cs.advprog.bidmart.bidding.repository.AuctionRepository;
import id.ac.ui.cs.advprog.bidmart.wallet.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private WalletService walletService;

    public List<Auction> getDummyAuctions() {
        return auctionRepository.findAll();
    }

    public String createDummyAuction() {
        Auction dummy = new Auction();
        dummy.setTitle("Lelang Sepatu Futsal Dummy");
        dummy.setStartingPrice(150000.0);
        auctionRepository.save(dummy);
        return "Data dummy ditambahkan";
    }

    public String placeBid(String userId, Long auctionId, Double amount) {

        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction tidak ditemukan"));
        walletService.holdBalance(userId, amount);

        return "Bid berhasil, saldo ditahan";
    }

    public String winAuction(String userId, Double amount) {

        walletService.deductHeldBalance(userId, amount);

        return "User menang lelang, saldo dipotong";
    }

    public String loseAuction(String userId, Double amount) {

        walletService.releaseHeldBalance(userId, amount);

        return "User kalah lelang, saldo dikembalikan";
    }
}