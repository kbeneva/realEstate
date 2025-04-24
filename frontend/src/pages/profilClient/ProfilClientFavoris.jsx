import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ProfileCard from "../../components/profile/ProfileCard.jsx";
import '../../components/profile/ProfileCard.css';
import '../profilAdmin/ProfilAdmin.css';
import './CustomerProfile.css';

function ProfilClientFavoris() {
    const [activeTab, setActiveTab] = useState("favorites");
    const navigate = useNavigate();

    const handleTabClick = (tab) => {
        setActiveTab(tab);
        if (tab === "requests") {
            navigate("/customerProfileRequests");
        } else if (tab === "submissions") {
            navigate("/customerProfileSubmissions");
        }
    };

    return (
        <div>
            <ProfileCard />
            <div className="tabContainer">
                <p
                    className={`tabItem ${activeTab === "favorites" ? "activeTab" : ""}`}
                    onClick={() => handleTabClick("favorites")}
                >
                    Favorites
                </p>
                <p
                    className={`tabItem ${activeTab === "requests" ? "activeTab" : ""}`}
                    onClick={() => handleTabClick("requests")}
                >
                    My requests
                </p>
                <p
                    className={`tabItem ${activeTab === "submissions" ? "activeTab" : ""}`}
                    onClick={() => handleTabClick("submissions")}
                >
                    My submissions
                </p>
            </div>
            <div className={"profileBodyBorder"}></div>
        </div>
    );
}

export default ProfilClientFavoris;