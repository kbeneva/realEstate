import React, { useState } from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";

function Navbar() {
    const [isCollapsed, setIsCollapsed] = useState(false);

    const toggleNavbar = () => {
        setIsCollapsed(!isCollapsed);
    };

    return (
        <nav className="navbar">
            <img className="logo" src="homeBreeze.png" alt="Logo" />
            <p className="homeBreeze">HomeBreeze</p>
            <div className={`navbarCollapse ${isCollapsed ? 'collapse' : ''}`}>
                <div className={"collapseLinkContainer"}>
                    <Link to="/sell">
                        <p className={"collapseLink"}>Sell</p>
                    </Link>
                    <Link to="/rent">
                        <p className={"collapseLink"}>Rent</p>
                    </Link>
                    <Link to="/login">
                        <p className={"collapseLink"}>Login</p>
                    </Link>
                </div>
            </div>
            <div className="linkContainer">
                <Link to="/sell">
                    <button className="link formLink">Sell</button>
                </Link>
                <Link to="/rent">
                    <button className="link formLink">Rent</button>
                </Link>
                <Link to="/login">
                    <button className="link loginLink">Login</button>
                </Link>
            </div>
            <button className="sideMenu" onClick={toggleNavbar}>
                <img className="sideMenuImg" src="sideMenu.png" alt="Menu" />
            </button>
        </nav>
    );
}

export default Navbar;