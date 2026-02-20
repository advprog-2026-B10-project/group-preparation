"use client";

import { useEffect, useState } from "react";
import { getUsers } from "@/lib/api";

export default function UsersPage() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getUsers().then(setUsers);
    }, []);

    return (
        <div>
            <h1>User List</h1>
            <ul>
                {users.map((u) => (
                    <li key={u.id}>
                        {u.name} - {u.email}
                    </li>
                ))}
            </ul>
        </div>
    );
}