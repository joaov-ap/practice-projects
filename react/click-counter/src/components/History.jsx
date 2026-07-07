import React, { useEffect } from "react";

function History({ history }) {
    return (
        <div>
            <ul>
                {history &&
                    history.map((item, index) => <li key={index}>{item}</li>)}
            </ul>
        </div>
    );
}

export default History;
