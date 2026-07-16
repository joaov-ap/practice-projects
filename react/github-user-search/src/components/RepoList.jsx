import React from "react";
import useFetch from "../hooks/useFetch";
import { useEffect, useState } from "react";

function RepoList({ repoUrl }) {
    const { data, request } = useFetch();
    const [topRepo, setTopRepo] = useState(null);

    useEffect(() => {
        request(repoUrl);
    }, [repoUrl]);

    useEffect(() => {
        if (!data) {
            return;
        }

        const sortedRepos = data.toSorted(
            (a, b) => b.stargazers_count - a.stargazers_count,
        );
        const bestRepos = sortedRepos.slice(0, 5);

        setTopRepo(bestRepos);
    }, [data]);

    return (
        <>
            {topRepo &&
                topRepo.map((repo) => (
                    <div key={repo.id}>
                        <h3>Repository: {repo.name}</h3>
                        <p>Stars number: {repo.stargazers_count}</p>
                        <p>Language: {repo.language}</p>
                        <p>Forks count: {repo.forks_count}</p>
                    </div>
                ))}
        </>
    );
}

export default RepoList;
