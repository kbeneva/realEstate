import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/navbar/Navbar.jsx";
import "./FormVendre.css";

function FormVendre() {
    const [started, setStarted] = useState(false);
    const [showLoginPopup, setShowLoginPopup] = useState(false);
    const [showErrorPopup, setShowErrorPopup] = useState(false);
    const [formData, setFormData] = useState({
        description: "",
        categorie: "",
        price: "",
        address: "",
        nbRooms: "",
        nbBathrooms: "",
        nbParkingSpace: "",
        nbGarages: "",
        area: "",
        constructionYear: "",
        city: ""
    });

    const navigate = useNavigate();

    const handleStart = () => {
        const user = JSON.parse(localStorage.getItem("user"));

        if (!user) {
            setShowLoginPopup(true);
        } else if (user.role === "customer") {
            setStarted(true);
        } else {
            setShowErrorPopup(true);
        }
    };

    const handleLoginRedirect = () => {
        navigate("/login");
    };

    const handleCancel = () => {
        navigate("/");
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("Submitting:", formData);

        try {
            const user = JSON.parse(localStorage.getItem("user"));
            const res = await fetch("http://localhost:9696/api/propertySale", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    ...formData,
                    customerId: user.idUser
                })
            });

            if (res.ok) {
                alert("Property submitted successfully!");
                navigate("/customerProfileFavorites");
            } else {
                alert("Failed to submit property.");
            }
        } catch (error) {
            console.error("Submit error:", error);
            alert("Error submitting form.");
        }
    };

    return (
        <div>
            <Navbar />

            {!started && (
                <div className="startPage">
                    <h1>Sell your home with HomeBreeze</h1>
                    <button className="startButton" onClick={handleStart}>Start</button>
                </div>
            )}

            {showLoginPopup && (
                <div className="popup">
                    <div className="popupContent">
                        <p>You must be logged in to sell a house.</p>
                        <button className={"popupButton1"} onClick={handleLoginRedirect}>Login</button>
                        <button className={"popupButton2"} onClick={handleCancel}>Cancel</button>
                    </div>
                </div>
            )}

            {showErrorPopup && (
                <div className="popup">
                    <div className="popupContent">
                        <p>Only customers can sell a house.</p>
                        <button className={"popupButton1"} onClick={handleCancel}>Return to Home</button>
                    </div>
                </div>
            )}

            {started && (
                <form className="propertyForm" onSubmit={handleSubmit}>
                    <h2>Property Details</h2>
                    <input name="categorie" type="text" placeholder="Category (house, condo...)"
                           value={formData.categorie} onChange={handleChange} required/>
                    <input name="address" type="text" placeholder="Address" value={formData.address}
                           onChange={handleChange} required/>
                    <input name="city" type="text" placeholder="City" value={formData.city} onChange={handleChange}
                           required/>
                    <input name="price" type="number" placeholder="Price" value={formData.price} onChange={handleChange}
                           required/>
                    <input name="description" type="text" placeholder="Description" value={formData.description}
                           onChange={handleChange} required/>
                    <input name="nbRooms" type="number" placeholder="Number of Rooms" value={formData.nbRooms}
                           onChange={handleChange} required/>
                    <input name="nbBathrooms" type="number" placeholder="Number of Bathrooms"
                           value={formData.nbBathrooms} onChange={handleChange} required/>
                    <input name="nbParkingSpace" type="number" placeholder="Number of Parking Spaces"
                           value={formData.nbParkingSpace} onChange={handleChange} required/>
                    <input name="nbGarages" type="number" placeholder="Number of Garages" value={formData.nbGarages}
                           onChange={handleChange} required/>
                    <input name="area" type="number" placeholder="Area (sqft)" value={formData.area}
                           onChange={handleChange} required/>
                    <input name="constructionYear" type="number" placeholder="Construction Year"
                           value={formData.constructionYear} onChange={handleChange} required/>

                    <button type="submit" className="submitButton">Submit</button>
                </form>
            )}
        </div>
    );
}

export default FormVendre;
