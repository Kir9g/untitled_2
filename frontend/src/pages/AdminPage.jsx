import React, { useState, useEffect } from "react";
import "../components/Modal.scss"; // Подключаем стили для Modal
import "../styles.scss"

import { postAdminEmail, postAdminVerify } from "../api/authorization";
import { setCookie } from "../api/utils";
import {Header} from "../components/Header.jsx";

export function AdminPage() {
    const [email, setEmail] = useState("");
    const [code, setCode] = useState("");
    const [emailSent, setEmailSent] = useState(false);
    const [emailPlaceholder, setEmailPlaceholder] = useState(" Email");
    const [codePlaceholder, setCodePlaceholder] = useState(" Код из письма");
    const [timer, setTimer] = useState(0);
    const [error, setError] = useState("");


    useEffect(() => {
        let interval;
        if (timer > 0) {
            interval = setInterval(() => {
                setTimer((prev) => prev - 1);
            }, 1000);
        } else {
            clearInterval(interval);
        }
        return () => clearInterval(interval);
    }, [timer]);

    const validateEmail = (email) => {
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,}$/;
        return emailRegex.test(email);
    };

    const handleSendCode = async () => {
        if (email.trim() === "" || timer !== 0) return;
        if (!validateEmail(email)) {
            setError("Введите корректный email.");
            return;
        }

        try {
            await postAdminEmail(email);
            setEmailSent(true);
            setTimer(60);
            setError("");
        } catch (error) {
            console.error("Ошибка при отправке email:", error);
            setError("Не удалось отправить код. Попробуйте еще раз.");
        }
    };

    const handleConfirmCode = async () => {
        if (code.trim() !== "") {
            try {
                const result = await postAdminVerify(email, code);
                setCookie("token", result);
                window.location.replace("/admin/requests")
            } catch (error) {
                console.error("Ошибка при отправке кода:", error);
                setError("Неверный код. Попробуйте еще раз.");
            }
        }
    };

    return (

        <div>
            <Header />
            <div className="container">
                <div className="content">
                    <div className="modal-content">
                        <h2 className="modal-title">Войти администратором</h2>

                        <input
                            type="email"
                            placeholder={emailPlaceholder}
                            className="modal-input"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            onFocus={() => setEmailPlaceholder("")}
                            onBlur={() => setEmailPlaceholder(" Email")}
                            maxLength="255"
                            disabled={emailSent}
                        />

                        {emailSent && (
                            <input
                                type="text"
                                placeholder={codePlaceholder}
                                className="modal-input"
                                value={code}
                                onChange={(e) => {
                                    const value = e.target.value.replace(/\D/g, "").slice(0, 4);
                                    setCode(value);
                                }}
                                onFocus={() => setCodePlaceholder("")}
                                onBlur={() => setCodePlaceholder(" Код из письма")}
                                inputMode="numeric"
                            />
                        )}

                        {error && <p className="modal-error">{error}</p>}



                        {!emailSent ? (
                            <button
                                onClick={handleSendCode}
                                className="modal-send-btn"
                                disabled={email.trim() === ""}
                            >
                                Отправить код
                            </button>
                        ) : (
                            <>
                                <button
                                    onClick={handleConfirmCode}
                                    className="modal-confirm-btn"
                                    disabled={code.trim().length !== 4}
                                >
                                    Подтвердить код
                                </button>
                                <button
                                    onClick={handleSendCode}
                                    className="modal-resend-btn"
                                    disabled={timer > 0}
                                >
                                    {timer > 0 ? `Запросить код заново (${timer}с)` : "Запросить код заново"}
                                </button>
                            </>
                        )}
                    </div>
                </div>
            </div>
        </div>


    );
}