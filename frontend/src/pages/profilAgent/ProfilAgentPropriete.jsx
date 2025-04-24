import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ProfileCard from "../../components/profile/ProfileCard.jsx";
import '../../components/profile/ProfileCard.css';
import '../profilAdmin/ProfilAdmin.css';
import '../profilClient/CustomerProfile.css';

function ProfilAgentPropriete() {
    const [activeTab, setActiveTab] = useState("requests");
    const navigate = useNavigate();

    const handleTabClick = (tab) => {
        if (tab !== activeTab) {
            setActiveTab(tab);
            if (tab === "requests") {
                navigate("/agentProfileCustomerRequests");
            }
        }
    };

    return (
        <div>
            <ProfileCard />
            <div className="tabContainer">
                <p
                    className={`tabItem ${activeTab === "properties" ? "activeTab" : ""}`}
                    onClick={() => handleTabClick("properties")}
                >
                    My properties
                </p>
                <p
                    className={`tabItem ${activeTab === "requests" ? "activeTab" : ""}`}
                    onClick={() => handleTabClick("requests")}
                >
                    Client requests
                </p>
            </div>
            <div className={"profileBodyBorder"}></div>
        </div>
    );
}

export default ProfilAgentPropriete;