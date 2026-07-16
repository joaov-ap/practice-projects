import React, { useState } from "react";
import SearchBar from "./components/SearchBar";
import UserCard from "./components/UserCard";
import RepoList from "./components/RepoList";

const App = () => {
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);

    return (
        <div>
            <SearchBar setValue={setUser} setError={setError} />
            {(user || error) && <UserCard value={user} error={error} />}
            {user && <RepoList repoUrl={user.repos_url} />}
        </div>
    );
};

export default App;
