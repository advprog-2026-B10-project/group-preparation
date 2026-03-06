package id.ac.ui.cs.advprog.bidmart.bidding.service;

import id.ac.ui.cs.advprog.bidmart.bidding.dto.CreateAuctionRequest;
import id.ac.ui.cs.advprog.bidmart.bidding.entity.Auction;
import id.ac.ui.cs.advprog.bidmart.bidding.entity.AuctionStatus;
import id.ac.ui.cs.advprog.bidmart.bidding.repository.AuctionRepository;
import id.ac.ui.cs.advprog.bidmart.wallet.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BiddingService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private WalletService walletService;

    public Auction createAuction(CreateAuctionRequest request) {

        Auction auction = new Auction();

        auction.setListingId(request.getListingId());
        auction.setStartingPrice(request.getStartingPrice());
        auction.setReservePrice(request.getReservePrice());

        LocalDateTime endTime = LocalDateTime.now().plusMinutes(request.getDurationInMinutes());
        auction.setEndTime(endTime);

        auction.setStatus(AuctionStatus.DRAFT);

        return auctionRepository.save(auction);
    }

    public String placeBid(String userId, Long auctionId, Double amount) {

        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction tidak ditemukan"));

        // 🔥 tahan saldo user ketika bid
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