"use client";

import { useEffect, useState } from "react";

export default function Home() {
  const [data, setData] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/test")
        .then(res => res.text())
        .then(result => setData(result))
        .catch(err => console.log(err));
  }, []);

  return (
      <div style={{ padding: "40px" }}>
        <h1>BidMart Frontend</h1>
        <p>Response dari Backend:</p>
        <h2>{data}</h2>
      </div>
  );
}