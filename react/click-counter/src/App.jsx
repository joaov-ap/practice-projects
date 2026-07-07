import { useEffect, useRef, useState } from "react";
import Counter from "./components/Counter";
import History from "./components/History";

function App() {
    const [count, setCount] = useState(() => {
        const countStoraged = window.localStorage.getItem("count");

        if (countStoraged) {
            return Number(countStoraged);
        }

        return 0;
    });
    const [history, setHistory] = useState([]);
    const isReady = useRef(false);

    useEffect(() => {
        if (!isReady.current) {
            isReady.current = true;
            return;
        }

        window.localStorage.setItem("count", Number(count));

        let newHistory = history;
        if (history.length > 10) {
            newHistory = newHistory.slice(1);
        }
        setHistory([...newHistory, count]);
    }, [count]);

    return (
        <div>
            <Counter count={count} setCount={setCount} />
            <History history={history} />
        </div>
    );
}

export default App;
