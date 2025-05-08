import {useEffect, useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import "./clientRequestList.css"
import {FaCheck} from "react-icons/fa";
import {RiCloseLargeFill} from "react-icons/ri";
import "../../pages/profilClient/CustomerProfile.css"


function AgentRequestList() {

    const [tabRequests, setRequests] = useState([]);
    const user = JSON.parse(localStorage.getItem("user"));
    const data = [
        `http://localhost:9696/RequestRent/agent/${user.idUser}`,
        `http://localhost:9696/RequestSale/agent/${user.idUser}`,
    ];


    const loadRequests = async () => {
        try {
            const results = await Promise.all(data.map(url => axios.get(url)));
            const allRequests = [...results[1].data, ...results[0].data]
            setRequests(allRequests)

        } catch (error) {
            console.error(error)
        }

    }

    const acceptRequest = async (id, typeDemande) => {
        try {
            await axios.put(`http://localhost:9696/Request${typeDemande}/accept/${id}`)

        }catch (error){
            console.log("Request put failed: " + error)
        }
    }

    const declineRequest = async (id, typeDemande) => {
        try {
            await axios.put(`http://localhost:9696/Request${typeDemande}/accept/${id}`)

        }catch (error){
            console.log("Request put failed: " + error)
        }
    }




    useEffect(() => {
        loadRequests();
    }, []);


    const handleAccept = async (e, id, typeDemande) => {
        try {
            e.preventDefault()
            acceptRequest(id, typeDemande)

        }catch (error){
            alert("There was a problem with your request: " + error)
        }

    };

    const handleDecline = async (e, id, typeDemande) => {
        try {
            e.preventDefault()
            declineRequest(id, typeDemande)

        }catch (error){
            alert("There was a problem with your request: " + error)
        }

    };


    console.log(tabRequests)


    return (
        <div>
            {tabRequests.length === 0 ? (
                <div className="defaultMessage">
                    No requests or submissions from clients found
                </div>
            ) : (
                <div className="cardContainer">
                    {tabRequests.map((data) => (
                        <Card className="cardRequests" key={data.idDemande}>
                            <Card.Body className="requestContent">
                                <div className="statusRequest">
                                    <span className="statusButtons">
                                        <button className="acceptRequest" onClick={(e) => handleAccept(e, data.idDemande, data.typeDemande)}>
                                            <FaCheck size={25} />
                                        </button>
                                        <button className="rejectRequest" onClick={(e) => handleDecline(e, data.idDemande, data.typeDemande)}>
                                            <RiCloseLargeFill size={25} style={{ stroke: "white", strokeWidth: "2" }} />
                                        </button>
                                    </span>
                                    <div className="statusTime">
                                        <div>{data.creationDate}</div>
                                    </div>
                                </div>

                                <div className="clientContainer">
                                    <div className="agentContainer">
                                        <div className="pfp">
                                            <img src="/pfp.jpg" alt="agent pfp" />
                                        </div>
                                        <div className="agentDetails">
                                            <div className="nameAgent">
                                                <p>{data.customer.fname}</p>
                                                <p>{data.customer.lname}</p>
                                            </div>
                                            <p>{data.customer.email}</p>
                                            <p>{data.customer.phone}</p>
                                        </div>
                                    </div>
                                    <div className="descRequest">
                                        {data.description}
                                    </div>
                                </div>
                            </Card.Body>
                        </Card>
                    ))}
                </div>
            )}
        </div>
    );
}

export default AgentRequestList;