import React, {useEffect, useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import "./clientRequestList.css"
import {MdDelete} from "react-icons/md";
import ImagePropertyList from "../propertiesDisplay/ImagePropertyList.jsx";
import {Link} from "react-router-dom";
import {forEach} from "react-bootstrap/ElementChildren";
import propertyType from "../filters/PropertyType.jsx";
import {tab} from "@material-tailwind/react";


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







    const handleDelete = async (id, propertyType) => {

        tabRequests.forEach(requests => {
            try {
                if (tabRequests.length > 0){
                    if (requests.statusDemande === "pending" || requests.statusDemande === "refused"){
                        if(confirm("Are you sure you want to permanently delete this request ? It will no longer be accessible to you or the agent") === true){
                            deleteRequest(id, propertyType)
                        }else {
                            alert("The request was canceled")
                        }

                    }else {
                        alert("You cannot delete this request")
                    }
                }

            }catch (error){
                alert("An error has occured with your request " + error)
            }

        })




    };



    const CapitalizedText = (text) => {
        return text.charAt(0).toUpperCase() + text.slice(1)
    };

    console.log(tabRequests)


    return (
        <div>

            <div className={"cardContainer"}>

                {tabRequests.map((data) => (

                    <Card className={"cardRequests"} key={data.idDemande}>

                        <Card.Body className={"requestContent"}>

                            <div className={"statusRequest"}>
                                <button className={"deleteRequest"}  onClick={() => handleDelete(data.idDemande, data.typeDemande)}>
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