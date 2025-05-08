import { useEffect, useState } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import "../../pages/profilClient/CustomerProfile.css";
import "../requestList/clientRequestList.css";
import { FaCheck } from "react-icons/fa";
import { RiCloseLargeFill } from "react-icons/ri";
import "./AgentSubmissionList.css";
import { FaLocationDot } from "react-icons/fa6";

function AgentSubmissionList() {
    const [submissions, setSubmissions] = useState([]);
    const user = JSON.parse(localStorage.getItem("user"));

    const endpoints = [
        "http://localhost:9696/PropertyRent/pending",
        "http://localhost:9696/PropertySale/pending"
    ];

    const loadSubmissions = async () => {
        try {
            const results = await Promise.all(endpoints.map(url => axios.get(url)));
            const allSubmissions = [...results[1].data, ...results[0].data];
            setSubmissions(allSubmissions);
        } catch (error) {
            console.error("Error loading submissions:", error);
        }
    };

    const removeSubmissionLocally = (id) => {
        setSubmissions(prev => prev.filter(s => s.idProperty !== id));
    };

    const acceptSubmission = async (id, type) => {
        try {
            await axios.put(`http://localhost:9696/Property${type}/accept/${id}`);
            await axios.put(`http://localhost:9696/Property${type}/updateOwner${id}`, null, {
                params: { idUser: user.idUser }
            });
            removeSubmissionLocally(id);
        } catch (error) {
            console.error("Error accepting submission:", error);
        }
    };

    const refuseSubmission = async (id, type) => {
        try {
            await axios.put(`http://localhost:9696/Property${type}/refuse/${id}`);
            removeSubmissionLocally(id);
        } catch (error) {
            console.error("Error refusing submission:", error);
        }
    };

    useEffect(() => {
        loadSubmissions();
    }, []);

    return (
        <div>
            {submissions.length === 0 ? (
                <div className="defaultMessage">No submissions from clients found</div>
            ) : (
                <div className="cardContainer">
                    {submissions.map((submission) => {
                        const type = submission.typeProperty === "rent" ? "Rent" : "Sale";
                        const customer = submission.customer;

                        return (
                            <Card className="cardRequests" key={submission.idProperty}>
                                <Card.Body className="requestContent submissionLayout">
                                    <div className="propertySection">
                                        <div className="statusButtons">
                                            <button className="acceptRequest" onClick={() => acceptSubmission(submission.idProperty, type)}>
                                                <FaCheck size={25} />
                                            </button>
                                            <button className="rejectRequest" onClick={() => refuseSubmission(submission.idProperty, type)}>
                                                <RiCloseLargeFill size={25} style={{ stroke: "white", strokeWidth: "2" }} />
                                            </button>
                                        </div>

                                        <div className="descRequest">
                                            <h2 className="submissionTitle">{submission.categorie || "No category"} for {submission.typeProperty}</h2>
                                            <p className="submissionPrice">
                                                {submission.price ? `${submission.price}$${submission.typeProperty === "rent" ? "/month" : ""}` : "N/A"}
                                            </p>
                                            <p className="submissionAddress">
                                                <FaLocationDot /> {submission.address || "No address"}, {submission.city || "Unknown"}
                                            </p>
                                        </div>
                                    </div>

                                    <div className="clientCard">
                                        <div className="agentContainer">
                                            <div className="pfp">
                                                <img src="/pfp.jpg" alt="client pfp" />
                                            </div>
                                            <div className="agentDetails">
                                                <div className="nameAgent">
                                                    <p>{customer?.fname}</p>
                                                    <p>{customer?.lname}</p>
                                                </div>
                                                <p>{customer?.email}</p>
                                                <p>{customer?.phone}</p>
                                            </div>
                                        </div>
                                    </div>
                                </Card.Body>
                            </Card>
                        );
                    })}
                </div>
            )}
        </div>
    );
}

export default AgentSubmissionList;
