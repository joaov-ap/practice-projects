import React from "react";
import { useState } from "react";
import useFetch from "../hooks/useFetch";
import { useEffect } from "react";

function SearchBar({ setValue, setError }) {
    const [input, setInput] = useState("");
    const { loading, request } = useFetch();

    async function handleClick() {
        if (!input.trim()) return;

        const { response, json } = await request(
            `https://api.github.com/users/${input}`,
        );

        if (response && response.ok) {
            setValue(json);
            setError(null);
        } else {
            setValue(null);
            setError(json?.message);
        }
    }

    return (
        <>
            <div>
                <input
                    type="text"
                    value={input}
                    onChange={({ target }) => setInput(target.value)}
                />
                <button onClick={handleClick} disabled={loading}>
                    {loading ? "Searching..." : "Search"}
                </button>
            </div>
        </>
    );
}

export default SearchBar;
