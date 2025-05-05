import React, {useEffect, useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import {v4 as uuidv4} from 'uuid';
import "./clientRequestList.css"
import {MdDelete} from "react-icons/md";
import ImagePropertyList from "./propertiesDisplay/ImagePropertyList.jsx";
import {Link} from "react-router-dom";
import {forEach} from "react-bootstrap/ElementChildren";


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
    useEffect(() => {
        loadRequests();
    }, []);



    const deleteRequest = async (id) => {
        await axios.delete(`http://localhost:9696/RequestSale/deleteRequest/${id}`);
        loadRequests();
    };

    const handleDelete = (id) => {


        if (tabRequests.statusDemande === "pending"){
            deleteRequest(id)
        }else if (tabRequests.statusDemande === 'accepted'){
            alert("Cannot delete accepted request")
        }else {
            alert("There was a problem with your request")
        }


    };



    const CapitalizedText = (text) => {
        return text.charAt(0).toUpperCase() + text.slice(1)
    };

    console.log(tabRequests)


    return (
        <div>

            <div className={"cardContainer"}>

                {tabRequests.map((data) => (

                    <Card className={"cardRequests"} key={uuidv4()}>

                        <Card.Body className={"requestContent"}>

                            <div className={"statusRequest"}>
                                <button className={"deleteRequest"}  onClick={() => handleDelete(data.idDemande)}>
                                    <MdDelete size={25}/>
                                </button>


                                <div className={"statusTime"}>

                                    <div> {data.creationDate}</div>
                                    <div className={"statusSection"}> {data.statusDemande}</div>
                                </div>
                            </div>


                            <div className={"carouselRequest"}>
                                <Link to={`/property/${CapitalizedText(data[`property${data.typeDemande}`]?.typeProperty)}/${data[`property${data.typeDemande}`]?.idProperty}`}>
                                <ImagePropertyList idPropriete={data[`property${data.typeDemande}`]?.idProperty}
                                                   typeProprety={data.typeDemande}/>
                                </Link>
                            </div>


                        </Card.Body>


                    </Card>

                ))}

            </div>

        </div>
    );
}

export default ClientRequestList;