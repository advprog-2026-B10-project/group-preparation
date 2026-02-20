const BASE_URL = "http://localhost:8080/api";

export async function getUsers() {
    const res = await fetch(`${BASE_URL}/users`);
    return res.json();
}

export async function createUser(user) {
    const res = await fetch(`${BASE_URL}/users`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
    });

    return res.json();
}