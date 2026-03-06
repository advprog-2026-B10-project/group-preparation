"use client";
import { useState } from "react";

export default function OrderPage() {
  const [listingId, setListingId] = useState("");
  const [username, setUsername] = useState("");
  const [price, setPrice] = useState("");
  const [result, setResult] = useState("");

  const createOrder = async () => {
    const res = await fetch(
      `http://localhost:8085/api/order/create?listingId=${listingId}&buyerUsername=${username}&finalPrice=${price}`,
      { method: "POST" }
    );

    const data = await res.json();
    setResult("Order ID: " + data.id);
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Order Module</h1>

      <input placeholder="Listing ID" onChange={e => setListingId(e.target.value)} />
      <br /><br />
      <input placeholder="Username" onChange={e => setUsername(e.target.value)} />
      <br /><br />
      <input placeholder="Final Price" onChange={e => setPrice(e.target.value)} />
      <br /><br />

      <button onClick={createOrder}>Create Order</button>

      <p>{result}</p>
    </div>
  );
}