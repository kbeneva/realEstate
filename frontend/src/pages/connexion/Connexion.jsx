import './Connexion.css';
import Navbar from "../../components/navbar/Navbar.jsx";
import { useState } from 'react';
import {useNavigate} from "react-router-dom";

function Connexion() {
    const [isActive, setIsActive] = useState(false);

    const handleRegisterClick = () => {
        setIsActive(true);
    };

    const handleLoginClick = () => {
        setIsActive(false);
    };

    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        const email = e.target[0].value;
        const password = e.target[1].value;

        const res = await fetch("http://localhost:9696/api/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password }),
        });

        const data = await res.text();

        if (res.ok) {
            if (data === "admin") navigate("/adminProfile");
            else if (data === "agent") navigate("/agentProfile");
            else navigate("/customerProfile");
        } else {
            alert(data);
        }
    };

    const handleRegister = async (e) => {
        e.preventDefault();
        const fname = e.target[0].value;
        const lname = "";
        const email = e.target[1].value;
        const phone = e.target[2].value;
        const password = e.target[3].value;

        const res = await fetch("http://localhost:9696/api/auth/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ fname, lname, email, phone, password }),
        });

        const data = await res.text();

        if (res.ok) {
            navigate("/customerProfile");
        } else {
            alert(data);
        }
    };


    return (
        <div>
            <Navbar />
            <div className={`connectionBackground`}>
                <div className={`connectionContainer ${isActive ? 'active' : ''}`}>
                    <div className={"formBox login"}>
                        <form className={"formWidth"} onSubmit={handleLogin}>
                            <h1 className={"connectionTitle"}>Sign in</h1>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Email" className={"connectionInput"} />
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="password" placeholder="Password" className={"connectionInput"} />
                            </div>
                            <button type="submit" className={"connectionSubmitButton"}>Login</button>
                        </form>
                    </div>

                    <div className={"formBox register"}>
                        <form className={"formWidth"} onSubmit={handleRegister}>
                            <h1 className={"connectionTitle"}>Register</h1>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="First name" className={"connectionInput"}/>
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Last name" className={"connectionInput"}/>
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Email" className={"connectionInput"}/>
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Phone" className={"connectionInput"}/>
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="password" placeholder="Password" className={"connectionInput"}/>
                            </div>
                            <button type="submit" className={"connectionSubmitButton"}>Register</button>
                        </form>
                    </div>

                    <div className={"toggleBox"}>
                        <div className={"togglePanel toggleLeft"}>
                            <h1 className={"toggleTitle"}>Hello, Welcome</h1>
                            <p className={"toggleText"}>Don&#39;t have an account?</p>
                            <button className={"registerToggleButton"} onClick={handleRegisterClick}>Register</button>
                        </div>
                        <div className={"togglePanel toggleRight"}>
                            <h1 className={"toggleTitle"}>Welcome back</h1>
                            <p className={"toggleText"}>Already have an account?</p>
                            <button className={"loginToggleButton"} onClick={handleLoginClick}>Login</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Connexion;