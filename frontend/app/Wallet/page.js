"use client"
import {useEffect,useState} from "react"

export default function Wallet(){
    const [balance,setBalance]=useState(0)

    useEffect(()=>{
        fetch("http://localhost:8084/api/wallet/balance")
            .then(res=>res.json())
            .then(setBalance)
    },[])

    return <div>Balance: {balance}</div>
}