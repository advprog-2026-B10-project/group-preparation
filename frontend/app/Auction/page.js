"use client";
import { useState } from "react";

export default function AuctionPage() {
    const [listingId, setListingId] = useState("");
    const [username, setUsername] = useState("");
    const [amount, setAmount] = useState("");
    const [result, setResult] = useState("");

    const placeBid = async () => {
        const res = await fetch("http://localhost:8083/api/auction/bid", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                listingId: parseInt(listingId),
                bidderUsername: username,
                amount: parseFloat(amount)
            })
        });

        const data = await res.json();
        setResult("Bid placed: " + data.amount);
    };

    return (
        <div style={{ padding: 20 }}>
            <h1>Auction Module</h1>
            <input placeholder="Listing ID" onChange={e => setListingId(e.target.value)} />
            <br /><br />
            <input placeholder="Username" onChange={e => setUsername(e.target.value)} />
            <br /><br />
            <input placeholder="Bid Amount" onChange={e => setAmount(e.target.value)} />
            <br /><br />
            <button onClick={placeBid}>Place Bid</button>

            <p>{result}</p>
        </div>
    );
}