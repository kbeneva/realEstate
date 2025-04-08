import './Connexion.css';
import Navbar from "../components/navbar/Navbar.jsx";
import { useState } from 'react';

function Connexion() {
    const [isActive, setIsActive] = useState(false);

    const handleRegisterClick = () => {
        setIsActive(true);
    };

    const handleLoginClick = () => {
        setIsActive(false);
    };

    return (
        <div>
            <Navbar />
            <div className={`connectionBackground`}>
                <div className={`connectionContainer ${isActive ? 'active' : ''}`}>
                    <div className={"formBox login"}>
                        <form className={"formWidth"} action={""}>
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
                        <form className={"formWidth"} action={""}>
                            <h1 className={"connectionTitle"}>Register</h1>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Name" className={"connectionInput"} />
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Email" className={"connectionInput"} />
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="text" placeholder="Phone" className={"connectionInput"} />
                            </div>
                            <div className={"connectionInputBox"}>
                                <input type="password" placeholder="Password" className={"connectionInput"} />
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