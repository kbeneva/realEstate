import {useEffect, useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import "./clientRequestList.css"
import {MdDelete} from "react-icons/md";
import ImagePropertyList from "../propertiesDisplay/ImagePropertyList.jsx";
import {Link} from "react-router-dom";



function ClientRequestList() {

    const [tabRequests, setRequests] = useState([]);
    const user = JSON.parse(localStorage.getItem("user"));

    const data = [
        `http://localhost:9696/RequestRent/customer/${user.idUser}`,
        `http://localhost:9696/RequestSale/customer/${user.idUser}`,
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

    const deleteRequest = async (id, propertyType) => {
        await axios.delete(`http://localhost:9696/Request${propertyType}/deleteRequest/${id}`);
        await loadRequests();

    };

    useEffect(() => {
        loadRequests();
    }, []);


    const handleDelete = async (data) => {

        try {

            if (data.statusDemande === "accepted") {
                alert("You cannot delete this request, it was already accepted")
                return
            }
            const confirmDelete = confirm("Are you sure you want to permanently delete this request ? It will no longer be accessible to you or the agent")
            if (confirmDelete) {
                deleteRequest(data.idDemande, data.typeDemande)
            } else {
                alert("The request was canceled")
            }

        } catch (error) {

            console.log("There was a problem with deleting the request" + data.idDemande + error)
        }

    };


    const CapitalizedText = (text) => {
        return text.charAt(0).toUpperCase() + text.slice(1)
    };

    console.log(tabRequests)



    return (
        <div>

            {tabRequests.length === 0 ? (
                <div style={{ textAlign: "center", padding: "40px", fontSize: "20px", color: "gray" }}>
                    You have no requests
                </div>
            ) : (

                <div className={"cardContainer"}>

                    {tabRequests.map((data) => (

                        <Card className={"cardRequests"} key={data.idDemande}>

                            <Card.Body className={"requestContent"}>

                                <div className={"statusRequest"}>
                                    <button className={"deleteRequest"} onClick={() => handleDelete(data)}>
                                        <MdDelete size={25}/>
                                    </button>


                                    <div className={"statusTime"}>

                                        <div> {data.creationDate}</div>
                                        <div className={"statusSection"} style={{
                                            background: data.statusDemande === "accepted" ? "#6abd71"
                                                : data.statusDemande === "rejected" ? "#FF6F61" : "#FFB02E"
                                        }}> {data.statusDemande}</div>
                                    </div>
                                </div>


                                <div className={"carouselRequest"}>
                                    <Link
                                        to={`/property/${CapitalizedText(data[`property${data.typeDemande}`]?.typeProperty)}/${data[`property${data.typeDemande}`]?.idProperty}`}>
                                        <ImagePropertyList idPropriete={data[`property${data.typeDemande}`]?.idProperty}
                                                           typeProprety={data.typeDemande}/>
                                    </Link>
                                </div>


                            </Card.Body>


                        </Card>

                    ))}

                </div>
            )}
        </div>


    );
}

export default ClientRequestList;