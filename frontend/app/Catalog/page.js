"use client";
import { useState, useEffect } from "react";

export default function CatalogPage() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [listings, setListings] = useState([]);

    const loadListings = async () => {
        const res = await fetch("http://localhost:8082/api/catalog");
        const data = await res.json();
        setListings(data);
    };

    useEffect(() => {
        loadListings();
    }, []);

    const createListing = async () => {
        await fetch("http://localhost:8082/api/catalog", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                title,
                description,
                startingPrice: parseFloat(price)
            })
        });
        loadListings();
    };

    return (
        <div style={{ padding: 20 }}>
            <h1>Catalog Module</h1>

            <input placeholder="Title" onChange={e => setTitle(e.target.value)} />
            <br /><br />
            <input placeholder="Description" onChange={e => setDescription(e.target.value)} />
            <br /><br />
            <input placeholder="Starting Price" onChange={e => setPrice(e.target.value)} />
            <br /><br />
            <button onClick={createListing}>Create Listing</button>

            <hr />
            <h2>All Listings</h2>
            {listings.map(item => (
                <div key={item.id}>
                    <b>{item.title}</b> - {item.startingPrice}
                </div>
            ))}
        </div>
    );
}