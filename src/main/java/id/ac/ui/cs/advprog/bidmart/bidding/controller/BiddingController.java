package id.ac.ui.cs.advprog.bidmart.bidding.controller;

import id.ac.ui.cs.advprog.bidmart.bidding.entity.Auction;
import id.ac.ui.cs.advprog.bidmart.bidding.service.BiddingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bidding")
@CrossOrigin(origins = "*")
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    @GetMapping("/dummy")
    public List<Auction> getDummyAuctions() {
        return biddingService.getDummyAuctions();
    }

    @PostMapping("/dummy")
    public String createDummyAuction() {
        return biddingService.createDummyAuction();
    }

    @PostMapping("/bid")
    public String placeBid(
            @RequestParam String userId,
            @RequestParam Long auctionId,
            @RequestParam Double amount
    ) {
        return biddingService.placeBid(userId, auctionId, amount);
    }

    @PostMapping("/win")
    public String winAuction(
            @RequestParam String userId,
            @RequestParam Double amount
    ) {
        return biddingService.winAuction(userId, amount);
    }

    @PostMapping("/lose")
    public String loseAuction(
            @RequestParam String userId,
            @RequestParam Double amount
    ) {
        return biddingService.loseAuction(userId, amount);
    }
}