import React from "react";
import "../../public/usercard.css";

function UserCard({ value, error }) {
    return (
        <>
            {error && <p>{error}</p>}
            {value && (
                <div className="container">
                    <img src={value.avatar_url} alt="user image" />
                    <h1>{value.name}</h1>
                    <h3>{value.bio}</h3>
                    <div>
                        <h2>Estatisticas</h2>
                        <ul>
                            <li>
                                <span className="boldtext">
                                    Repositórios públicos:{" "}
                                </span>{" "}
                                {value.public_repos}
                            </li>
                            <li>
                                <span className="boldtext">
                                    Gists públicos:{" "}
                                </span>{" "}
                                {value.public_gists}
                            </li>
                            <li>
                                <span className="boldtext">Seguidores: </span>
                                {value.followers}
                            </li>
                            <li>
                                <span className="boldtext">Seguindo: </span>
                                {value.following}
                            </li>
                        </ul>
                    </div>
                </div>
            )}
        </>
    );
}

export default UserCard;
