import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import ProfileCard from "../../components/profile/ProfileCard.jsx";
import "../profilAdmin/ProfilAdmin.css";
import "./CustomerProfile.css";
import axios from "axios";
import { FaLocationDot } from "react-icons/fa6";

function ProfilClientLocation() {
    const [activeTab, setActiveTab] = useState("submissions");
    const [submissions, setSubmissions] = useState([]);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();
    const storedUser = JSON.parse(localStorage.getItem("user") || "{}");

    const data = [
        `http://localhost:9696/propertyRent/customer/${storedUser.idUser}`,
        `http://localhost:9696/propertySale/customer/${storedUser.idUser}`,
    ];

    useEffect(() => {
        const fetchSubmissions = async () => {

            if (!storedUser?.idUser) {
                setLoading(false);
                return;
            }
            try {
                const response = await Promise.all(data.map(url => axios.get(url)));
                const allRequests = [...response[1].data, ...response[0].data]
                setSubmissions(allRequests);


            } catch (error) {
                console.error("Error fetching rental submissions:", error);
                setSubmissions([]);
            } finally {
                setLoading(false);
            }
        };

        fetchSubmissions();
    }, []);

    const handleTabClick = (tab) => {
        setActiveTab(tab);
        if (tab === "favorites") {
            navigate("/customerProfileFavorites");
        } else if (tab === "requests") {
            navigate("/customerProfileRequests");
        } else if (tab === "submissions") {
            navigate("/customerProfileSubmissionsRent");
        }
    };

    console.log(submissions)

    return (
        <div>
            <ProfileCard />
            <div className="tabContainer">
                <p className={`tabItem ${activeTab === "favorites" ? "activeTab" : ""}`} onClick={() => handleTabClick("favorites")}>Favorites</p>
                <p className={`tabItem ${activeTab === "requests" ? "activeTab" : ""}`} onClick={() => handleTabClick("requests")}>My requests</p>
                <p className={`tabItem ${activeTab === "submissions" ? "activeTab" : ""}`} onClick={() => handleTabClick("submissions")}>My submissions</p>
            </div>
            <div className="profileBodyBorder">
                {loading ? (
                    <p>Loading submissions...</p>
                ) : (
                    <>
                        {submissions.length > 0 ? (
                            <div className="submissionContainer">
                                {submissions.map((submission) => (
                                    <div key={submission.idProperty} className="submissionCard">
                                        <h2 className="submissionTitle">{submission.categorie || "No category"}</h2>
                                        <p className="submissionPrice">{submission.price ? `${submission.price}$` : "N/A"}</p>
                                        <p className="submissionAddress">
                                            <FaLocationDot />
                                            {submission.address || "No address"}, {submission.city || "Unknown"}
                                        </p>
                                        <p className="submissionStatus">{submission.isAccepted ? "Accepted" : "Pending"}</p>
                                    </div>
                                ))}
                            </div>
                        ) : (
                            <p className="defaultMessage">No submissions found.</p>
                        )}
                    </>
                )}
            </div>
        </div>
    );
}

export default ProfilClientLocation;
