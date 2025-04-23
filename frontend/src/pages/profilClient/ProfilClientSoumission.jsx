import {useState} from "react";
import {useNavigate} from "react-router-dom";
import ProfileCard from "../../components/profile/ProfileCard.jsx";
import '../profilAdmin/ProfilAdmin.css';
import './CustomerProfile.css';

function ProfilClientSoumission() {
    const [activeTab, setActiveTab] = useState("submissions");
    const navigate = useNavigate();

    const handleTabClick = (tab) => {
        setActiveTab(tab);
        if (tab === "favorites") {
            navigate("/customerProfileFavorites");
        } else if (tab === "requests") {
            navigate("/customerProfileRequests");
        }
    };

    return (
        <div>
            <ProfileCard/>
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
                >
                    My submissions
                </p>
            </div>
            <div className={"profileBodyBorder"}></div>
        </div>);
}

export default ProfilClientSoumission;