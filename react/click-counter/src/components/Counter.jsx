import { use, useRef, useState } from "react";
import "../css/counter.css";

function Counter({ count, setCount }) {
    let number = useRef();
    let timeoutRef = useRef();

    function handleNumberChange(color) {
        clearTimeout(timeoutRef.current);
        number.current.classList.add(color);
        timeoutRef.current = setTimeout(() => {
            number.current.classList.remove(color);
        }, 500);
    }

    function onIncrement() {
        setCount((count) => count + 1);
        handleNumberChange("green");
    }

    function onDecrement() {
        if (count === 0) {
            return;
        }

        setCount((count) => count - 1);
        handleNumberChange("red");
    }

    function onReset() {
        setCount(0);
    }

    return (
        <div className="container">
            <p className="number" ref={number}>
                {count}
            </p>
            <div className="buttons-container">
                <button className="button" onClick={onIncrement}>
                    Incrementar
                </button>
                <button className="button" onClick={onDecrement}>
                    Decrementar
                </button>
                <button className="button" onClick={onReset}>
                    Resetar
                </button>
            </div>
        </div>
    );
}

export default Counter;
